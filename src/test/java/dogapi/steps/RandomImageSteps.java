package dogapi.steps;

import dogapi.logic.RandomImageLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class RandomImageSteps {

    private final RandomImageLogic randomImageLogic = new RandomImageLogic();

    @Given("que possuo dados validos para consultar uma imagem aleatoria")
    public void que_possuo_dados_validos_para_consultar_uma_imagem_aleatoria() {
        // Nenhuma preparação necessária para esse endpoint
    }

    @When("realizo uma requisicao GET para o endpoint de imagem aleatoria")
    public void realizo_uma_requisicao_get_para_o_endpoint_de_imagem_aleatoria() {
        // reaproveitando o response compartilhado do CommonSteps
        CommonSteps.response = randomImageLogic.getRandomImage();
    }

    @Then("a url da imagem retornada nao deve ser vazia")
    public void a_url_da_imagem_retornada_nao_deve_ser_vazia() {
        String imageUrl = CommonSteps.response.jsonPath().getString("message");

        Assertions.assertNotNull(imageUrl, "URL da imagem nao deve ser nula");
        Assertions.assertFalse(imageUrl.isBlank(), "URL da imagem nao deve ser vazia");
    }
}
