package works.worksTest;

import io.restassured.response.Response;
import org.junit.Test;
import works.base_urls.AutoExerciseBaseUrl;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.*;

public class Work13 extends AutoExerciseBaseUrl {

    /*
	Given
		https://automationexercise.com/api/productsList
	When
		User sends Get request
	Then
		Assert that number of "Women" usertype is 12
		(Kadın usertype sayısının 12 olduğunu doğrulayın)

*/

    @Test
    public void work13(){
        spec.pathParam("first", "productsList");
        Response response = given().spec(spec).when().get("{first}");
        response.jsonPath().prettyPrint();

        Integer expectedData = response.jsonPath().getList("products.findAll{it.category.usertype.usertype=='Women'}").size();
        assertTrue(expectedData==12);
    }

}
