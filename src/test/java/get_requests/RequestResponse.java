package get_requests;

import io.restassured.response.Response;
import utilities.ReusableMethods;

import java.util.Map;

import static io.restassured.RestAssured.get;

public class RequestResponse extends ReusableMethods{

    /*
    1) Postman manuel API testi icin kullanilir
    2) API automation'u icin Rest Assured Library
    3) Otomasyon kodlarinin yazimi icin su adimlari izliyoruz:
        a) Gereksinimleri anlama
        b) Test case'i yazma:
            -Test case'i yazmak icin "Gherkin Language" kullaniyoruz.
            x) Given: On kosullar --> Endpoint, body
            y) When: Islemler --> Get, Put, Delete ...
            z) Then: Donutler --> Assert
            t) And: Coklu islemlerin art arda yazilacagi yerlerde kullanilir.
        c) Test kodunu yazarken su adimlari izleriz:
            i)   Set the URL
            ii)  Set the expected data
            iii) Send the request and get the response
            iv)  Do assertion
     */

    public static void main(String[] args) {

        String path = "https://restful-booker.herokuapp.com/booking/55";

        //Get request nasil yapilir:
        Response response = get(path);
        response.prettyPrint();

        //Status Code nasil yazdirilir?
        System.out.println("Status Code: " + response.statusCode());

        //Content Type nasil yazdirilir?
        System.out.println("Content Type: " + response.contentType());

        //Status Line nasil yazdirilir?
        System.out.println("Status Line: " + response.statusLine());

        //Header nasil yazdirilir:
        System.out.println(response.header("Connection"));
        System.out.println(response.header("Server"));

        //Headers nasil yazdirilir:
        System.out.println(response.headers());

        //Time Nasil yazdirilir:
        System.out.println("Time: " + response.getTime());



    }


}
