package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.List;

import static io.restassured.RestAssured.*;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL == > URL'e Get Request gonderin
      Then
          1)Status code is 200 == > Status kodu 200 olmali
          2)Print all ids greater than 190 on the console ==> id si 190 dan buyuk olanlari konsola yazdirin
            Assert that there are 10 ids greater than 190 == > 10 tane id nin 190 dan buyuk oldugunu dogrulayin+
          3)Print all userIds whose ids are less than 5 on the console ==> id si 5 den kucuk olan tum userid lerini konsolunu yazdirin+
            Assert that the number of userIds whose ids are less than 5 is 4 ==> id si 5 den kucuk olan 4 tane userId oldugunu dogrulayin+
          4)Print all titles whose ids are less than 5 ==> ıd si 5 den kucuk olan tum basliklari yazdirin
            Assert that "delectus aut autem" is one of the titles whose id is less than 5 ==> id si 5 den kucuk olan datalarin birinin
            basliginin "delectus aut autem" icerdigini dogrulayin
     */

    @Test
    public void get07(){
        spec.pathParams("first", "todos");
        Response response = given().spec(spec).when().get("/{first}");

        JsonPath jsonPath = response.jsonPath();
        response.then().statusCode(200);


        List<Object> list = jsonPath.getList("findAll{it.id>190}");
        System.out.println(list);

        Assert.assertTrue(list.size()==10);
        
        List<Object> list2 = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println(list2);

        Assert.assertTrue(list2.size()==4);

        List<Object> list3 = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println(list3);

        Assert.assertEquals(true , list3.contains("delectus aut autem"));

    }

}
