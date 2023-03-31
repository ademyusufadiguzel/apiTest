package works.worksTest;

import base_urls.DummyRestApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

public class Work15 extends DummyRestApiBaseUrl {

    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language

           Assert:  i) Status code is 200
                    ii) There are 24 employees
                   (HamcrestMatcher kullanarak 24 employees olduğunu doğrulayınız)
                    iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   (HamcrestMatcher kullanarak "Tiger Nixon" ve "Garrett Winters"'ın employees arasında olduğunu doğrulayınız' )
                    iv) The greatest age is 66
                   (En büyük yaşın 66 olduğunu doğrulayınız)
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   (En düşük yaşın isminin Tatyana Fitzpatrick olduğunu doğrulayınız)
                    vi) Total salary of all employees is 6,644,770
                   (Tüm employees salary toplamının  6,644,770 olduğunu doğrulayınız)
    */

    @Test
    public void work15(){
        spec.pathParam("first","employees");
        Response response = given(spec).when().get("{first}");
        JsonPath jsPath = response.jsonPath();
        response.prettyPrint();
        assertEquals(200, response.statusCode());
        response.then().body("data.id",hasSize(24),"data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));
        List<Integer> ages = jsPath.getList("data.employee_age");
        System.out.println("ages = " + ages);
        
        Collections.sort(ages);
        System.out.println("Sorted id = " + ages);

        int expectedData = ages.get(ages.size()-1);
        assertEquals(66,expectedData);

        String name = jsPath.getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        System.out.println("name = " + name);
        assertEquals("[Tatyana Fitzpatrick]",name);

        List<Integer> salarys = jsPath.getList("data.findAll{it.employee_salary}.employee_salary");
        System.out.println("salarys = " + salarys);

        int sum = salarys.stream().reduce(0,Math::addExact);
        assertEquals(6644770, sum);



    }

}
