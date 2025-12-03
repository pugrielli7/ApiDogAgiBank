package dogapi.steps;

import dogapi.logic.BreedPoodleImagesLogic;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class BreedPoodleImagesSteps {

    private final BreedPoodleImagesLogic logic = new BreedPoodleImagesLogic();

    @Given("que possuo dados validos para consultar imagens da raca poodle")
    public void que_possuo_dados_validos_para_consultar_imagens_da_raca_poodle() {
        // Nenhuma preparação adicional
    }

    @When("realizo uma requisicao GET para o endpoint de imagens do poodle")
    public void realizo_uma_requisicao_get_para_o_endpoint_de_imagens_do_poodle() {
        CommonSteps.response = logic.getPoodleImages();
    }

    @And("a lista de imagens da raca poodle nao deve ser vazia")
    public void a_lista_de_imagens_da_raca_poodle_nao_deve_ser_vazia() {
        List<String> imagens =
                CommonSteps.response.jsonPath().getList("message");

        Assertions.assertNotNull(imagens, "Lista de imagens nao deve ser nula");
        Assertions.assertFalse(imagens.isEmpty(), "Lista de imagens nao deve ser vazia");

        System.out.println("===== IMAGENS DO POODLE =====");
        imagens.stream()
                .limit(10)
                .forEach(url -> System.out.println("Imagem -> " + url));
        System.out.println("Total de imagens: " + imagens.size());
        System.out.println("================================");
    }
}
