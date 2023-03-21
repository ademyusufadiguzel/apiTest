package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.JsonPlaceHoldersPojo;
import util.ObjectMapperUtils;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

    /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
          }


       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like  {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
*/

    @Test
    public void post05ObjectMapper_Pojo(){
        spec.pathParam("first" , "todos");
        JsonPlaceHoldersPojo expectedData = new JsonPlaceHoldersPojo(55, "Tidy your room", false);
        Response response = given().spec(spec).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        JsonPlaceHoldersPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHoldersPojo.class);
        System.out.println(actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }

}
