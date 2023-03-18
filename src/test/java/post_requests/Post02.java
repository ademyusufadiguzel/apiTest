package post_requests;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import test_data.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Post02 extends HerokuappBaseUrl {

    /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test
    public void post02() {
        spec.pathParam("first", "booking");
        HerOkuAppTestData obj = new HerOkuAppTestData();
        Map<String, String> bookingdatesMap = obj.bookingdatesMapMethod("2021-09-09", "2021-09-21");
        Map<String, Object> expectedData = obj.expectedDataMethod("John", "Doe", 11111, true, bookingdatesMap, null);

        Response response = given().spec(spec).body(expectedData).when().post("/{first}");
        response.prettyPrint();
        Map<String, Object> actualData = response.as(HashMap.class);
        SoftAssert softAssert = new SoftAssert();

        Assert.assertEquals(actualData.get("booking"), expectedData);


    }
}