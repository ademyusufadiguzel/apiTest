package utilities;

import io.restassured.response.Response;
import static io.restassured.RestAssured.get;
public class ReusableMethods {

    public static String getRequestWithID(String id) {
        Response response;
        response = get("https://restful-booker.herokuapp.com/booking/"+id);
        return response.prettyPrint();
    }

}
