package works.worksTest;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.HerOkuApp.BookingDatesPojo;
import pojos.HerOkuApp.BookingPojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;

public class Work14 extends HerokuappBaseUrl {

       /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                  {
                    "firstname": "Jane",
                    "lastname": "Doe",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Extra pillows please"
                }
                (TestNG Soft assertion yapınız)
     */

    @Test
    public void work14(){
        spec.pathParams("first", "booking", "second", 22);
        BookingDatesPojo datespojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jane","Doe", 111,true,datespojo,"Extra pillows please");
        System.out.println("expectedData = " + expectedData);

        Response response = given(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);
        System.out.println("actualData = " + actualData);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(datespojo.getCheckin(), actualData.getBookingdates().getCheckin());
        softAssert.assertEquals(datespojo.getCheckout(), actualData.getBookingdates().getCheckout());
        softAssert.assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        softAssert.assertEquals(expectedData.getLastname(), actualData.getLastname());
        softAssert.assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        softAssert.assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        softAssert.assertEquals(expectedData.getAdditionalneeds(), actualData.getAdditionalneeds());

        softAssert.assertAll();


    }

}
