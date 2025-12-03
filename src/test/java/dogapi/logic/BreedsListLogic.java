package dogapi.logic;

import dogapi.base.BaseApiTest;
import io.restassured.response.Response;

public class BreedsListLogic extends BaseApiTest {

    public Response getAllBreeds() {
        return givenBase()
                .when()
                .get("/breeds/list/all")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
