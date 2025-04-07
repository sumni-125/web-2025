package food;

 

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

public class FoodService2 {

    FoodDAO dao = new FoodDAO();
    Gson gson = new Gson();

    // 단일 음식 정보 JSON 문자열 반환
    public String getFoodInfo() {
        Food food = new Food("볶음밥", "6000");
        return gson.toJson(food);
    }

    // 리스트 + 페이지 정보 JSON 문자열 반환
    public String getFoodListPaging(int page) {
        List<Food> list = new ArrayList<>();
        list.add(new Food("볶음밥", "6000"));
        list.add(new Food("김밥", "4000"));
        list.add(new Food("쫄면", "6000"));

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", list);
        resultMap.put("page", page);

        return gson.toJson(resultMap);
    }

    // DAO에서 가져온 리스트 + 페이지 정보 JSON 문자열 반환
    public String getFoodRealListPaging(int page) {
    	
        List<Food> list = dao.getFoodListPaging(page);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("list", list);
        resultMap.put("page", page);

        return gson.toJson(resultMap);
    }
}
