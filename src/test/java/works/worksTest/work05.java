package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import works.base_urls.ReqresBaserUrl;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class work05 extends ReqresBaserUrl {

    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json; charset=utf-8”
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */

    @Test
    public void work05() {

        spec.pathParams("first", "unknown","second",3);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        response.then().statusCode(200).contentType("application/json; charset=utf-8");

        JsonPath jsonPath = response.jsonPath();
        SoftAssert softAssert = new SoftAssert();

        /*
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
         */
        softAssert.assertEquals(jsonPath.getInt("data.id"), 3, "data.id failed");
        softAssert.assertEquals(jsonPath.getString("data.name"), "true red", "data.name failed");
        softAssert.assertEquals(jsonPath.getInt("data.year"), 2002, "data.year failed");
        softAssert.assertEquals(jsonPath.getString("data.color"), "#BF1932", "data.color failed");
        softAssert.assertEquals(jsonPath.getString("data.pantone_value"), "19-1664", "data.pantone_value failed");
        softAssert.assertEquals(jsonPath.getString("support.url"), "https://reqres.in/#support-heading", "support.url failed");
        softAssert.assertEquals(jsonPath.getString("support.text"), "To keep ReqRes free, contributions towards server costs are appreciated!", "support.text failed");

        softAssert.assertAll();
    }


}
