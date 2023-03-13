package get_requests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;

public class Get02 extends ReusableMethods {

    /*
        Given
            https://restful-booker.herokuapp.com/booking/0
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

    static Response response;

    @Test
    public void get02(){
        getRequestWithID("0",response);

        allResponse.then().
                statusCode(404). //HTTP Status code should be 404
                statusLine("HTTP/1.1 404 Not Found"); //Status Line should be HTTP/1.1 404 Not Found

        //Response body contains "Not Found"
        //assertTrue() methodu, method parantezi içindeki değerin false olması durumda test "fail" olur.
        Assert.assertTrue(allResponse.asString().contains("Not Found"));

        //Response body does not contain "TechProEd"
        //assertFalse() methodu, method parantezi içindeki değerin true olması durumda test "fail" olur.
        Assert.assertFalse(allResponse.asString().contains("TechProEd"));

        //Server is "Cowboy"
        Assert.assertTrue(allResponse.header("Server").contains("Cowboy"));

    }


}
