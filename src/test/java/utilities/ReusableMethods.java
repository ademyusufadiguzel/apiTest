package utilities;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.junit.Before;

import java.util.*;

import static io.restassured.RestAssured.get;

public abstract class ReusableMethods {

    protected static Response allResponse;

    public static void getRequestWithID(String id, Response response) {
        response = get("https://restful-booker.herokuapp.com/booking/"+id);
        allResponse = response;
        allResponse.prettyPrint();
    }

    public static void getStatusCode(){
        System.out.println("Status Code: " + allResponse.statusCode());
    }

    public static void getContentType(){
        System.out.println("Content Type: " + allResponse.contentType());
    }

    public static void getStatusLine(){
        System.out.println("Status Line: " + allResponse.statusLine());
    }

    public static void getHeaders(){
        System.out.println(allResponse.headers());
    }

    public static void getHeader(String headerKey){
        System.out.println(headerKey+": " + allResponse.header(headerKey));
    }

    public static void getTime(){
        System.out.println("Time: " + allResponse.getTime());
    }

}