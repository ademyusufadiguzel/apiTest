package get_requests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get11 {

    /*
        Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 10
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
            "Gov. Vrinda Panicker", "Sen. Devika Embranthiri" and "Mandaakin Bhattacharya" are among the users
        And
            The female users are less than or equals to male users
            (Kadın kullanıcı sayısı erkek kullanıcı sayısından küçük yada eşit olamlı)
     */

    @Test
    public void get11(){
        Response response = get("https://gorest.co.in/public/v1/users");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();

        response.then().statusCode(200).
                body("meta.pagination.limit",equalTo(10),"meta.pagination.links.current",
                        equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data",hasSize(10),
                        "data.status",hasItem("active"),
                        "data.name",hasItems("Uttam Varman", "Agniprava Verma Esq.", "Devasree Pandey"));

        // 1. Yol:
        List<String> genders = jsonPath.getList("data.gender");
        System.out.println(genders);
        int kadinCounter = 0;
        for (String w : genders){
            if (w.equals("female")) {
                kadinCounter++;
            }
        }
        Assert.assertTrue(kadinCounter<=genders.size()-kadinCounter);


        // 2. Yol:
        List<String> kadinKullaniciList = jsonPath.getList("data.findAll{it.gender=='female'}.gender");
        List<String> erkekKullaniciList = jsonPath.getList("data.findAll{it.gender=='male'}.gender");
        System.out.println(kadinKullaniciList);
        Assert.assertTrue(kadinKullaniciList.size()<=erkekKullaniciList.size());


    }


}
