package get_requests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get04 {

    /*
        Given
            https://jsonplaceholder.typicode.com/todos
        When
	 	    I send a GET request to the Url
	    And
	        Accept type is “application/json”
	    Then
	        HTTP Status Code should be 200
	    And
	        Response format should be "application/json"
	    And
	        There should be 200 todos
	    And
	        "quis eius est sint explicabo" should be one of the todos title
	    And
	        2, 7, and 9 should be among the userIds
     */

    @Test
    public void get04(){

        //Set the URL
        //String url = "https://jsonplaceholder.typicode.com/todos";

        //Set the expected data

        //Send the request and get the response
        Response response = given().accept(ContentType.JSON).when().get();
        response.then().
                statusCode(200).
                contentType("application/json").
                contentType(ContentType.JSON).
                body("title",equalTo("quis eius est sint explicabo"),"id",hasSize(200),"userId",hasItems(2,7,9));

    }

}
