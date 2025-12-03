package dogapi.steps;

import dogapi.logic.BreedsListLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

import java.util.Map;

public class BreedsListSteps {

    private final BreedsListLogic logic = new BreedsListLogic();

    @Given("que possuo dados validos para consultar a lista de racas")
    public void que_possuo_dados_validos_para_consultar_a_lista_de_racas() {
        // Nenhuma preparação necessária para este endpoint
    }

    @When("realizo uma requisicao GET para o endpoint de lista de racas")
    public void realizo_uma_requisicao_get_para_o_endpoint_de_lista_de_racas() {
        CommonSteps.response = logic.getAllBreeds();
    }

    @And("a lista de racas nao deve ser vazia")
    public void a_lista_de_racas_nao_deve_ser_vazia() {
        Map<String, Object> breeds =
                CommonSteps.response.jsonPath().getMap("message");

        Assertions.assertNotNull(breeds, "Campo 'message' nao deve ser nulo");
        Assertions.assertFalse(breeds.isEmpty(), "Lista de racas nao deve ser vazia");

        // Impressão para você ver TODAS as raças no console
        System.out.println("===== LISTA COMPLETA DE RACAS =====");
        breeds.keySet().forEach(raca -> System.out.println("Raca -> " + raca));
        System.out.println("Quantidade total de racas: " + breeds.size());
        System.out.println("===================================");
    }
}
