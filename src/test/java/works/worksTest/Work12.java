package works.worksTest;

import io.restassured.response.Response;
import org.junit.Test;
import works.base_urls.PetStoreBaseUrl;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Work12 extends PetStoreBaseUrl {

    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        User sens Get request
    Then
        Assert that number of pets whose status is "available" is more than 100
     */


    @Test
    public void work12(){

        spec.pathParams("first", "pet","second", "findByStatus").queryParam("status", "available");

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Integer expectedData = response.jsonPath().getList("findAll{it.status=='available'}").size();
        System.out.println(expectedData);
        assertTrue(expectedData>100);

    }

}
