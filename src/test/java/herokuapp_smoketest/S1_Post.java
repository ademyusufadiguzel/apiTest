package herokuapp_smoketest;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.HerOkuApp.BookingDatesPojo;
import pojos.HerOkuApp.BookingPojo;
import pojos.HerOkuApp.BookingResponsePojo;
import util.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class S1_Post extends HerokuappBaseUrl {
    /*
    Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname" : "Jim",
            "lastname" : "Brown",
            "totalprice" : 111,
            "depositpaid" : true,
            "bookingdates" : {
                "checkin" : "2018-01-01",
                "checkout" : "2019-01-01"
            },
            "additionalneeds" : "Breakfast"
        }
    When
        Send post request
    Then
        Status Code should be 200
    And
        Body should be like:
        {
            "bookingid": 9268,
            "booking": {
                "firstname": "Jim",
                "lastname": "Brown",
                "totalprice": 111,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2018-01-01",
                    "checkout": "2019-01-01"
                },
                "additionalneeds": "Breakfast"
            }
        }


     */

    static int bookingId;
    @Test
    public void post01(){
        spec.pathParam("first", "booking");

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Jim", "Brown", 111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().body(expectedData).post("/{first}");
        response.prettyPrint();

        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(),actualData.getBooking().getFirstname());
        assertEquals(expectedData.getLastname(),actualData.getBooking().getLastname());
        assertEquals(expectedData.getTotalprice(),actualData.getBooking().getTotalprice());
        assertEquals(expectedData.getDepositpaid(),actualData.getBooking().getDepositpaid());
        assertEquals(bookingDatesPojo.getCheckin(),actualData.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingDatesPojo.getCheckout(),actualData.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalneeds(), actualData.getBooking().getAdditionalneeds());

        bookingId = actualData.getBookingid();

    }


}