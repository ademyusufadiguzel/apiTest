package works.worksTest;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import works.base_urls.ReqresBaserUrl;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Work02 extends ReqresBaserUrl {

    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty
     */

    static Response response;

    @Test
    public void work02(){
        //Set the URL
//        String url = "https://reqres.in/api/users/23";
        spec.pathParams("first", "users","second", 23);

        //Set the expected data

        //Send the request GET the response
        response = given().spec(spec).when().get("/{first}/{second}");

        //Do assertion
        response.then().statusCode(404).statusLine("HTTP/1.1 404 Not Found").header("Server", "cloudflare");
        assert response.getBody().asString().contains("{}");


    }

}
