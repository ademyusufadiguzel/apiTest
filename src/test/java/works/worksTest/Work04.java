package works.worksTest;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Work04 extends HerokuappBaseUrl {

        /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"

     */

    @Test
    public void work04(){

        spec.pathParam("first", "booking").queryParams("firstname","Almedin","lastname","Alikadic");

        Response response = given().spec(spec).when().get("/{first}");

        response.prettyPrint();

        Assert.assertTrue(response.asString().replaceAll("\\s","").length()==2);

    }

}
