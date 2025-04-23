package tripMate.servlet;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import tripMate.model.MarkerData;

@WebServlet("/tripMap")
public class tripMapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String startStr = (String) session.getAttribute("selectedStart");
        String endStr = (String) session.getAttribute("selectedEnd");

        if (startStr != null && endStr != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date startDate = sdf.parse(startStr);
                Date endDate = sdf.parse(endStr);

                ArrayList<String> dayList = new ArrayList<>();
                Calendar cal = Calendar.getInstance();
                cal.setTime(startDate);

                int dayCount = 1;
                while (!cal.getTime().after(endDate)) {
                    dayList.add("day" + dayCount);
                    cal.add(Calendar.DATE, 1);
                    dayCount++;
                }

                String dayListJson = new Gson().toJson(dayList);
                req.setAttribute("dayListJson", dayListJson);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        req.getRequestDispatcher("WEB-INF/views/map.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonData = req.getReader().lines().collect(Collectors.joining());
        Gson gson = new Gson();
        Type type = new TypeToken<List<MarkerData>>() {}.getType();
        List<MarkerData> markersList = gson.fromJson(jsonData, type);

        markersList.sort(Comparator.comparingInt(m -> Integer.parseInt(m.getDayS().replace("day", ""))));

        Map<String, Integer> dayCountMap = new HashMap<>();
        for (MarkerData marker : markersList) {
            String day = marker.getDayS();
            int count = dayCountMap.getOrDefault(day, 0) + 1;
            marker.setDayOrder(count);
            dayCountMap.put(day, count);
        }

        HttpSession session = req.getSession();
        System.out.println(markersList);
        session.setAttribute("savedMarkers", markersList);

        resp.setContentType("application/json");
        resp.getWriter().write("{\"status\": \"success\"}");
    }
}