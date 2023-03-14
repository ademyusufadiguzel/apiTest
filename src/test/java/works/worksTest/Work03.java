package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import works.base_urls.ReqresBaserUrl;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Work03 extends ReqresBaserUrl {

    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    static Response response;

    @Test
    public void work03(){
        //Set the URL
//        String url = "https://reqres.in/api/users/2";
        spec.pathParams("first","users","second",2);
        //Set the expected data

        //Send the request and get the response
        response = given().spec(spec).when().get("/{first}/{second}");
        response.then().statusCode(200).contentType(ContentType.JSON).
                body("data.email", equalTo("janet.weaver@reqres.in")
                        , "data.first_name",equalTo("Janet")
                        ,"data.last_name",equalTo("Weaver")
                        , "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));
    }
}