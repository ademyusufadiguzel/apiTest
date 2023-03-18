package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class HerokuappBaseUrl {

    protected RequestSpecification spec;
    @Before//her test method'undan once calisir.
    public void setUp(){
        spec = new RequestSpecBuilder().setContentType(ContentType.JSON).setBaseUri("https://restful-booker.herokuapp.com").build();
    }

}
