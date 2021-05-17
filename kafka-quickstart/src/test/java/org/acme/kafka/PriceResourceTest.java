package org.acme.kafka;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class PriceResourceTest {

    public void testHelloEndpoint() {
        given()
          .when().get("/hello-resteasy")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}