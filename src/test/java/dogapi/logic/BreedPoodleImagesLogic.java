package dogapi.logic;

import dogapi.base.BaseApiTest;
import io.restassured.response.Response;

public class BreedPoodleImagesLogic extends BaseApiTest {

    public Response getPoodleImages() {
        return givenBase()
                .when()
                .get("/breed/poodle/images")
                .then()
                .log().all()
                .extract()
                .response();
    }
}
