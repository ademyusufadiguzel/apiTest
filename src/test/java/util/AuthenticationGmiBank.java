package util;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGmiBank {

    public static String generateToken(){
        Map<String,Object> tokenBody = new HashMap<>();
        tokenBody.put("username", "batch_yuzuc");
        tokenBody.put("password", "Batch.103");

        Response response = given().contentType(ContentType.JSON).body(tokenBody).post("https://gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");
    }

}
