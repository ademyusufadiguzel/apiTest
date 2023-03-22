package herokuapp_smoketest;

import base_urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.HerOkuApp.BookingDatesPojo;
import pojos.HerOkuApp.BookingPojo;
import pojos.HerOkuApp.BookingResponsePojo;
import util.ObjectMapperUtils;
import static util.AuthenticationHerOkuApp.generateToken;

import static herokuapp_smoketest.S1_Post.bookingId;
import static io.restassured.RestAssured.given;

public class S2_Put extends HerokuappBaseUrl {

    /*
    Given:
        1) https://restful-booker.herokuapp.com/booking/{id}
        2) {
     */

    @Test
    public void put01(){
        spec.pathParams("first", "booking", "second",4259);

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData = new BookingPojo("Adem","Can", 111,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec)
                .header("Cookie","token="+generateToken())
                .body(expectedData).put("/{first}/{second}");
        response.prettyPrint();

//        BookingResponsePojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingResponsePojo.class);
//        System.out.println("actualData = " + actualData);

        //TOKEN ALMAK

    }

}
