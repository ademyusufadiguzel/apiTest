package delete_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApi.DummyRestApiDeletePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Delete02 extends DummyRestApiBaseUrl {

       /*
URL: https://dummy.restapiexample.com/api/v1/delete/2
HTTP Request Method: DELETE Request
Test Case: Type by using Gherkin Language
Assert:     i) Status code is 200
            ii) "status" is "success"
            iii) "data" is "2"
            iv) "message" is "Successfully! Record has been deleted"


        Given:
            https://dummy.restapiexample.com/api/v1/delete/2
        When
            User sends Delete request
        Then
           HTTP Status Code should be 200
        And
            "status" is "success"
        And
            "data" is "2"
        And
            "message" is "Successfully! Record has been deleted"
  */

    @Test
    public void delete02(){
        spec.pathParams("first", "delete", "second", 2);

        DummyRestApiDeletePojo expectedData = new DummyRestApiDeletePojo("success", 2, "Successfully! Record has been deleted");

        Response response = given(spec).when().delete("/{first}/{second}");
        response.prettyPrint();
        DummyRestApiDeletePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiDeletePojo.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getStatus(), actualData.getStatus());
        assertEquals(expectedData.getData(), actualData.getData());
        assertEquals(expectedData.getMessage(), actualData.getMessage());

    }

}
