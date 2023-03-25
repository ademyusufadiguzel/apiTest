package post_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApi.DummyRestApiDataPojo;
import pojos.DummyRestApi.DummyRestApiResponsePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post06 extends DummyRestApiBaseUrl {

    /*
    Given
       URL: https://dummy.restapiexample.com/api/v1/create
       Request body:{
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image",
                        "id": 4891
             }
    When
       HTTP Request Method: POST Request
    Then
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Tom Hanks",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 4891
                        },
                        "message": "Successfully! Record has been added."
                    }
     */

    @Test
    public void post06(){
        spec.pathParam("first", "create");

        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Tom Hanks",111111,23,"Perfect image");
        DummyRestApiResponsePojo body = new DummyRestApiResponsePojo("success",expectedData,"Successfully! Record has been added.");
        System.out.println("body = " + body);
        Response response = given(spec).when().body(expectedData).post("/{first}");
        DummyRestApiResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getProfile_image(),actualData.getData().getProfile_image());
        assertEquals(expectedData.getEmployee_age(),actualData.getData().getEmployee_age());
        assertEquals(expectedData.getEmployee_name(),actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(),actualData.getData().getEmployee_salary());
        assertEquals(body.getStatus(),actualData.getStatus());
        assertEquals(body.getMessage(),actualData.getMessage());






    }

}
