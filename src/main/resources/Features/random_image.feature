Feature: Consultar imagem aleatoria de cachorro

  @random_image
  Scenario: Consultar imagem aleatoria com sucesso
    Given que possuo dados validos para consultar uma imagem aleatoria
    When realizo uma requisicao GET para o endpoint de imagem aleatoria
    Then o sistema retorna codigo de status 200
    And o campo status da resposta deve ser "success"
    And a url da imagem retornada nao deve ser vazia
