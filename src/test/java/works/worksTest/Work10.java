package works.worksTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;
import works.base_urls.ZippopotamBaseUrl;
import works.pojos.zippo.ZippopotamDataPojo;
import works.pojos.zippo.ZippopotamPojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        ZippopotamDataPojo expectedData = new ZippopotamDataPojo("Vitoria-Gasteiz","-2.6667", "Pais Vasco","PV","42.85");
        ZippopotamPojo body = new ZippopotamPojo("01001", "Spain","ES",expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String,Object> actualData = response.as(HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(body.getPost_code(), actualData.get("post code"));
        assertEquals(body.getCountry_abbreviation(), actualData.get("country abbreviation"));
        assertEquals(body.getCountry(), actualData.get("country"));
        assertEquals(body.getPlaces().getPlace_name(), ((Map)((List)actualData.get("places")).get(0)).get("place name"));
        assertEquals(body.getPlaces().getLongitude(), ((Map)((List)actualData.get("places")).get(0)).get("longitude"));
        assertEquals(body.getPlaces().getState(), ((Map)((List)actualData.get("places")).get(0)).get("state"));
        assertEquals(body.getPlaces().getState_abbreviation(), ((Map)((List)actualData.get("places")).get(0)).get("state abbreviation"));
        assertEquals(body.getPlaces().getLatitude(), ((Map)((List)actualData.get("places")).get(0)).get("latitude"));

    }


}
