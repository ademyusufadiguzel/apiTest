package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public Map<String,Object> expectedDataMethod(Integer userId, String title, Boolean completed){
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", userId);
        expectedData.put("title", title);
        expectedData.put("completed", completed);


        return expectedData;
    }

    public static String expectedDataInString(Integer userId, String title, Boolean completed){

        return " \"userId\": "+userId+", \"title\": \""+title+"\", \"completed\": "+completed+"}";

    }

}


/*
{ "userId": 10, "id": 198, "title": "quis eius est sint explicabo", "completed": true}
 */

/*
    Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 21.0);
        expectedData.put("title", "Wash the dishes");
        expectedData.put("completed", false);
 */
