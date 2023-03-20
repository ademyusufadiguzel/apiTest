package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import works.base_urls.ReqresBaserUrl;
import works.test_data.ReqresTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Work07 extends ReqresBaserUrl {

    /*
        Given
            1) https://reqres.in/api/users
            2) {
                "name": "morpheus",
                "job": "leader"
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
            And response body should be like {
                                                "name": "morpheus",
                                                "job": "leader",
                                                "id": "496",
                                                "createdAt": "2022-10-04T15:18:56.372Z"
                                              }
     */

    @Test
    public void work07(){
        spec.pathParam("first", "users");
        ReqresTestData reqres = new ReqresTestData();

        Map<String, Object> expectedData = reqres.expectedDataMethod("morpheus","leader");

        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).post("/{first}");
        response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("name"), actualData.get("name"));
        Assert.assertEquals(expectedData.get("job"), actualData.get("job"));

    }
}