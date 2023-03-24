package herokuapp_smoketest;


import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class S3_Delete extends HerokuappBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking/429
    When
        Send delete request
    Then
        Status code should be 201
    And
        Body should be "Created"
     */
    @Test
    public void delete01(){
        //Set the url
        spec.pathParams("first", "booking", "second", bookingId);

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given().spec(spec).when().delete("/{first}/{second}");

        response.prettyPrint();

        //Do assertion
        assertEquals(201, response.statusCode());
        assertEquals(expectedData, response.asString());


    }

}