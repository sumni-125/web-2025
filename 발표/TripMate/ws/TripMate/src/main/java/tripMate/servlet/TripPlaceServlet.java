package tripMate.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import tripMate.service.PlaceService;

@WebServlet("/tripPlace")
public class TripPlaceServlet extends HttpServlet {
    
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
    	String action = req.getParameter("action");
        
        if (action == null || action.equals("list")) {
            showPlaceList(req, resp);
        } else if (action.equals("add"))  {
            addPlace(req, resp);
        } /*else if (action.equals("delete")) {
            deletePlace(req, resp);
        }*/
    }


    private void showPlaceList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
    	PlaceService p = new PlaceService();
        ArrayList placeList = p.getList();
        
        req.setAttribute("placeList", placeList);
        req.getRequestDispatcher("WEB-INF/views/tripPlace.jsp").forward(req, resp);
    } 

    
    
    private void addPlace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        HttpSession session = req.getSession();
       
      
        session.setAttribute("myPlace", name);
        resp.sendRedirect(req.getContextPath() + "/tripPlace?action=list");
    }

  
    
    
    
    /*
    private void deletePlace(HttpServletRequest req, HttpServletResponse resp) throws IOException {
       
    	String name = req.getParameter("name");
        HttpSession session = req.getSession();
        Object result = session.getAttribute("myPlace");
       
        
        if (result != null) {
            ArrayList<String> myPlace = (ArrayList<String>) result;
            myPlace.remove(name);
            
            session.setAttribute("myPlace", myPlace);
        }
        resp.sendRedirect(req.getContextPath() + "/tripPlace?action=list");
    }
    */


	
}
