Feature: Listar todas as racas de caes

  @breeds_list_all
  Scenario: Consultar lista completa de racas com sucesso
    Given que possuo dados validos para consultar a lista de racas
    When realizo uma requisicao GET para o endpoint de lista de racas
    Then o sistema retorna codigo de status 200
    And o campo status da resposta deve ser "success"
    And a lista de racas nao deve ser vazia
