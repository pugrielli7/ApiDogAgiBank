Feature: Consultar imagens de poodle

  @poodle_images
  Scenario: Consultar imagens da raca poodle com sucesso
    Given que possuo dados validos para consultar imagens da raca poodle
    When realizo uma requisicao GET para o endpoint de imagens do poodle
    Then o sistema retorna codigo de status 200
    And o campo status da resposta deve ser "success"
    And a lista de imagens da raca poodle nao deve ser vazia
