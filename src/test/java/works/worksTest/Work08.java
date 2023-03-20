package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import works.base_urls.PetStoreBaseUrl;
import works.test_data.PetStoreTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Work08 extends PetStoreBaseUrl {

    /*
   "https://petstore.swagger.io/" dökümanını kullanarak 'user' oluşturacak bir otomasyon testi yazınız
    Not: Test Case'i gherkin language ile yazınız.

    Given:
        1) https://petstore.swagger.io/v2/user
        2) {
                  "username": "Tony",
                  "firstName": "Tony",
                  "lastName": "Stark",
                  "email": "tony.stark@gmail.com",
                  "password": "1234",
                  "phone": "1234",
                  "userStatus": 123
                }

    When
            I send POST Request to the Url
    Then
            Status code is 201
            And response body should be like {
                                               "code": 200,
                                               "type": "unknown",
                                               "message": "9223372036854764029"
                                              }
*/

    @Test
    public void work08() {

        spec.pathParams("first", "user");

        PetStoreTestData petStore = new PetStoreTestData();
        Map<String, Object> expectedData = petStore.expectedDataMethod("SpaceX", "Elon", "Musk", "elonMusk.SpaceX@gmail.com", "1234567", "123456789", 321);
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("unknown", actualData.get("type"));
        Assert.assertEquals(200, actualData.get("code"));
    }
}