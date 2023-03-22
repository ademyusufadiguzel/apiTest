package works.worksTest;

import base_urls.GoRestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import util.ObjectMapperUtils;
import works.base_urls.GorestBaseUrl;
import works.pojos.GorestPojo;

import static io.restassured.RestAssured.*;
import static org.testng.AssertJUnit.assertEquals;

public class Work09 extends GorestBaseUrl {

    /*
        Given
           https://gorest.co.in/public/v2/posts/174
       When
            Kullanıcı GET Methodu ile Request Gönder
        Then
             Status Code un "200" olduğunu Assert et
        And
            Response body nin bu şekilde olduğunu doğrula
 {
    "id": 174,
    "user_id": 612,
    "title": "Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.",
    "body": "Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo."
}

     */

    @Test
    public void work08(){
        spec.pathParams("p1", "public","p2","v2","p3","posts","p4",174);

        GorestPojo expectedData = new GorestPojo(174,612,"Tertius valeo sint est vesica doloribus rerum casus cetera nisi sapiente vigor pecus voluptas asperiores et sto vapulus.","Et demens tergo. Cohors copia adeptio. Cotidie speciosus coaegresco. Concido crastinus degero. Tristis fugit supellex. Sustineo cogo odit. Pel patria crur. Amplus comitatus modi. Ater omnis solutio. Voluptatem acies unde. Taceo delinquo ustilo. Alo possimus vaco. Sit cognomen thesaurus. Appositus vel amicitia. Cetera textus defungo.");

        Response response = given().spec(spec).when().get("/{p1}/{p2}/{p3}/{p4}");
        response.prettyPrint();

        GorestPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), GorestPojo.class);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getUser_id(), actualData.getUser_id());
        assertEquals(expectedData.getTitle(), actualData.getTitle());
        assertEquals(expectedData.getBody(), actualData.getBody());

    }

}
