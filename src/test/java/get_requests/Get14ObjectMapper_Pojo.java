package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHoldersPojo;
import test_data.JsonPlaceHolderTestData;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonPlaceHolderBaseUrl {

/*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get14ObjectMapper_Pojo() {
        spec.pathParams("first", "todos", "second", 198);

        JsonPlaceHoldersPojo expectedData = new JsonPlaceHoldersPojo(10, "quis eius est sint explicabo", true);
        System.out.println("expectedData: " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");

        JsonPlaceHoldersPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), JsonPlaceHoldersPojo.class);
        System.out.println("actualData: " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getUserId(), actualData.getUserId());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getCompleted(), actualData.getCompleted());


    }

}
