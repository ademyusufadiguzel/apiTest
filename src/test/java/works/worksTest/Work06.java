package works.worksTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import works.base_urls.ReqresBaserUrl;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Work06 extends ReqresBaserUrl {

    /*
       Given
              https://reqres.in/api/unknown/
       When
            I send GET Request to the URL
       Then

            1)Status code is 200
            2)Print all pantone_values
              (Tüm pantone_value değerlerini yazdırınız)
            3)Print all ids greater than 3 on the console
              (3'ten büyük id'leri yazdırınız)
              Assert that there are 3 ids greater than 3
              (3'ten büyük 3 adet id olduğunu doğrulayınız)
            4)Print all names whose ids are less than 3 on the console
              (id'si 3'ten küçük isimleri yazdırınız)
              Assert that the number of names whose ids are less than 3 is 2
              (id'si 3'ten küçük 2 isim olduğunu doğrulayınız)
    */

    @Test
    public void work06(){
        spec.pathParam("first", "unknown");
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200);
        List<String> pantone_value = jsonPath.getList("data.findAll{it.pantone_value}.pantone_value");
        System.out.println(pantone_value);

        List<String> ids = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println(ids);
        Assert.assertEquals(3, ids.size());

        List<String> idNames = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println(idNames);
        Assert.assertEquals(2, idNames.size());

    }

}
