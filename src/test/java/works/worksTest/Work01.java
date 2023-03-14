package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import works.base_urls.ReqresBaserUrl;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Work01 extends ReqresBaserUrl {

    /*
        Given
            https://reqres.in/api/users/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */

    static Response response;

    @Test
    public void work01(){



        //Set the URL
//        String url = "https://reqres.in/api/users/3";
        spec.pathParams("first","users","second",3);


        //Send the request GET the response
        response = given().spec(spec).when().get("/{first}/{second}");

        //Set the expected data

        //Send the request and get the response
        response.then().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");





    }

}
