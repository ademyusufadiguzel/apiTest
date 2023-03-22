package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;
import works.base_urls.ZippopotamBaseUrl;
import works.pojos.zippo.ZippopotamDataPojo;
import works.pojos.zippo.ZippopotamPojo;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Work10 extends ZippopotamBaseUrl {

    /*
        Given
            http://api.zippopotam.us/ES/01001
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
            {
    "post code": "01001",
    "country": "Spain",
    "country abbreviation": "ES",
    "places": [
        {
            "place name": "Vitoria-Gasteiz",
            "longitude": "-2.6667",
            "state": "Pais Vasco",
            "state abbreviation": "PV",
            "latitude": "42.85"
        }
    ]
}
     */

    @Test
    public void work10(){
        spec.pathParams("first", "ES", "second", "01001");

        ZippopotamDataPojo expectedData = new ZippopotamDataPojo("Vitoria-Gasteiz","-2.6667","Pais Vasco","PV","42.85");
        System.out.println("expectedData = " + expectedData);
        ZippopotamPojo body = new ZippopotamPojo("01001","Spain","ES",expectedData);


        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        ZippopotamPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), ZippopotamPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(body.getPost_code(), actualData.getPost_code());
        assertEquals(body.getCountry(), actualData.getCountry());
        assertEquals(body.getCountry_abbreviation(), actualData.getCountry_abbreviation());
        assertEquals(expectedData.getPlace_name(), actualData.getPlaces().getPlace_name());
        assertEquals(expectedData.getLongitude(), actualData.getPlaces().getLongitude());
        assertEquals(expectedData.getState(), actualData.getPlaces().getState());
        assertEquals(expectedData.getState_abbreviation(), actualData.getPlaces().getState_abbreviation());
        assertEquals(expectedData.getLatitude(), actualData.getPlaces().getLatitude());



    }


}
