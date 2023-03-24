package works.worksTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.Test;
import works.base_urls.Covid19BaseUrl;
import works.pojos.Covid19Pojo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Work11 extends Covid19BaseUrl {

    /*
        Given
           https://api.covid19api.com/world/total
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "TotalConfirmed": 674300771,
    "TotalDeaths": 6793224,
    "TotalRecovered": 0
}
     */

    @Test
    public void work11() throws IOException {

        spec.pathParams("first", "world", "second", "total");
        ObjectMapper objectMapper = new ObjectMapper();

        Covid19Pojo expectedData = new Covid19Pojo(674300771, 6793224, 0);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getTotalConfirmed(), actualData.get("TotalConfirmed"));
        assertEquals(expectedData.getTotalDeaths(), actualData.get("TotalDeaths"));
        assertEquals(expectedData.getTotalRecovered(), actualData.get("TotalRecovered"));


    }

}
