package dogapi.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public abstract class BaseApiTest {

    protected RequestSpecification givenBase() {
        String baseUrl = System.getProperty("baseUrl", "https://dog.ceo/api");

        return RestAssured
                .given()
                .baseUri(baseUrl)
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .log().all();
    }
}
