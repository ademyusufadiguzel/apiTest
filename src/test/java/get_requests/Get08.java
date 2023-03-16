package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Get08 extends JsonPlaceHolderBaseUrl {

    /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */

    @Test
    public void get08(){

        spec.pathParams("first", "todos", "second", 2);
        Response response = given().spec(spec).when().get("/{first}/{second}");
        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);

        // 1. Yol:
        Assert.assertEquals(false, jsonPath.getBoolean("completed"));
        Assert.assertEquals(1, jsonPath.getInt("userId"));
        Assert.assertEquals("quis ut nam facilis et officia qui", jsonPath.getString("title"));
        Assert.assertEquals("1.1 vegur", response.header("Via"));
        Assert.assertEquals("cloudflare", response.header("Server"));

        // 2. Yol:
        JsonPlaceHolderTestData testData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedData = testData.expectedDataMethod(1,"quis ut nam facilis et officia qui",false);
        Map<String, Object> actualData = response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
        Assert.assertEquals("1.1 vegur", response.header("Via"));
        Assert.assertEquals("cloudflare", response.header("Server"));



    }

}
