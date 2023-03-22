package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static util.AuthenticationHerOkuApp.generateToken;

public class HerokuappBaseUrl {

    protected RequestSpecification spec;
    @Before//her test method'undan once calisir.
    public void setUp(){
        spec = new RequestSpecBuilder().addHeader("Cookie", "token="+generateToken ()).setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
