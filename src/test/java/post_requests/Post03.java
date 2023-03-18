package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHoldersPojo;
import test_data.JsonPlaceHolderTestData;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
            }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post03(){

        spec.pathParam("first", "todos");

        JsonPlaceHoldersPojo expectedData = new JsonPlaceHoldersPojo(55,"Tidy your room", false);

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("{first}");
        response.prettyPrint();

        JsonPlaceHoldersPojo actualData = response.as(JsonPlaceHoldersPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());
    }

}
