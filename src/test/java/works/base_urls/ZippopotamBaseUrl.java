package works.base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class ZippopotamBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setAccept(ContentType.JSON).setContentType(ContentType.JSON).setBaseUri("http://api.zippopotam.us").build();
    }

}
