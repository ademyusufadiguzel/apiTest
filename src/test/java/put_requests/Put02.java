package put_requests;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApi.DummyRestApiDataPojo;
import pojos.DummyRestApi.DummyRestApiResponsePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Put02 extends DummyRestApiBaseUrl {

    /*
        URL: https://dummy.restapiexample.com/api/v1/update/21
       HTTP Request Method: PUT Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }
     */
    /*
        Given:
            1) https://dummy.restapiexample.com/api/v1/update/21
            2) Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
        When:
	 		I send PUT Request to the Url
	    Then:
	        i) Status code is 200
            ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image"
                        },
                        "message": "Successfully! Record has been updated."
                    }

     */

    @Test
    public void put02(){
        spec.pathParams("first","update","second",21);

        DummyRestApiDataPojo expectedData = new DummyRestApiDataPojo("Ali Can",111111,23,"Perfect image");
        System.out.println("expectedData = " + expectedData);

        DummyRestApiResponsePojo responsePojo = new DummyRestApiResponsePojo("success", expectedData, "Successfully! Record has been updated.");
        //responsePojo objesini actualData ile karsilastirarak assertion yapmak icin olusturduk.


        Response response = given().spec(spec).body(expectedData).when().put("/{first}/{second}");
//        response.prettyPrint();

        DummyRestApiResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), DummyRestApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getEmployee_name(), actualData.getData().getEmployee_name());
        assertEquals(expectedData.getEmployee_salary(), actualData.getData().getEmployee_salary());
        assertEquals(expectedData.getEmployee_age(), actualData.getData().getEmployee_age());
        assertEquals(expectedData.getProfile_image(), actualData.getData().getProfile_image());
        assertEquals(responsePojo.getMessage(), actualData.getMessage());
        assertEquals(responsePojo.getStatus(), actualData.getStatus());





    }

}
