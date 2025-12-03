package dogapi.logic;

import dogapi.base.BaseApiTest;
import io.restassured.response.Response;

public class RandomImageLogic extends BaseApiTest {

    public Response getRandomImage() {

        Response randomImageResponse =
                givenBase()
                        .when()
                        .get("/breeds/image/random")
                        .then()
                        .log().all()        // loga requisição + resposta
                        .extract()
                        .response();

        // Prints de apoio
        String imageUrl = randomImageResponse.jsonPath().getString("message");
        System.out.println("===== IMAGEM ALEATORIA =====");
        System.out.println("URL da imagem: " + imageUrl);
        System.out.println("================================");

        return randomImageResponse;
    }
}
