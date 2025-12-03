package dogapi.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

public class CommonSteps {

    public static Response response;

    @Then("o sistema retorna codigo de status {int}")
    public void o_sistema_retorna_codigo_de_status(Integer statusCode) {
        Assertions.assertEquals(
                statusCode.intValue(),
                response.statusCode(),
                "Status code diferente do esperado"
        );
    }

    @And("o campo status da resposta deve ser {string}")
    public void o_campo_status_da_resposta_deve_ser(String statusEsperado) {
        String statusAtual = response.jsonPath().getString("status");
        Assertions.assertEquals(
                statusEsperado,
                statusAtual,
                "Campo status diferente do esperado"
        );
    }
}
