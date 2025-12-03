🐶 Dog API – Testes Automatizados (Java + RestAssured + JUnit + Cucumber)

Este projeto contém testes automatizados da Dog API (https://dog.ceo/
) seguindo um padrão clean, organizado e semelhante ao utilizado em grandes bancos, com foco em:

Separação clara entre Steps, Logic, Runner e Features

Uso de RestAssured para requisições

Uso de Gherkin (Given / When / Then)

Testes simples, legíveis e fáceis de manter

📌 O que é testado

O projeto cobre 3 funcionalidades principais da Dog API:

✅ 1. Listar todas as raças

Chama o endpoint /breeds/list/all

Valida:

Status code 200

Status “success” no JSON

Que existe ao menos uma raça

Exibe no console a lista completa e a quantidade total

✅ 2. Listar imagens da raça Poodle

Chama o endpoint /breed/poodle/images

Valida:

Status code 200

Status “success”

A lista de imagens não está vazia

Imprime as primeiras imagens e a quantidade total

✅ 3. Buscar uma imagem aleatória

Chama /breeds/image/random

Valida:

Status code 200

Status “success”

O campo message contém uma URL válida de imagem

Exibe a URL gerada no console

🧱 Estrutura do Projeto (alto nível, sem mostrar código)

O projeto segue uma estrutura clara e padronizada, inspirada no modelo de automações utilizado no Bradesco:

src
└── test
└── java
└── dogapi
├── base         → Classe base para configurar o RestAssured
├── constants    → URLs e valores fixos
├── logic        → Camada que chama os endpoints
├── steps        → Implementação dos steps do Gherkin
├── runner       → Execução dos cenários
└── Features     → Cenários escritos em Gherkin

🧩 Explicação das camadas
base/

Contém a classe que configura a URL base, headers e métodos utilitários.

constants/

Armazena os endpoints da API (ex.: /breeds/list/all).

logic/

É a camada que executa a requisição.
Nada de validação aqui — apenas chamada do endpoint.

steps/

Tradução dos passos do Gherkin em ações:

Prepara dados

Chama a lógica

Faz validações

Imprime resultados

runner/

Define quais Features serão executadas e integra com JUnit + Cucumber.

Features/

Arquivos .feature com os cenários escritos assim:

Given em inglês

E os steps em português, como você pediu

🛠️ Pré-requisitos

Você precisa ter instalado:

Java 17 ou 21

Maven

IDE (IntelliJ recomendado)

▶️ Como executar
Rodar todos os testes
mvn test

Rodar por Feature

Na IDE:
Runner > Botão direito > Run

📊 O que aparece no console

Os testes imprimem informações úteis:

Para imagens do poodle:

Lista das primeiras imagens

Total de imagens encontradas

Para lista de raças:

Todas as raças (uma por linha)

Total de raças retornadas

Para imagem aleatória:

A URL gerada (ex.: retriever, poodle, pug… totalmente aleatório)

🔍 Sobre falso positivo

Os testes foram construídos para evitar falso positivo:

Validam status code

Validam campo "status"

Validam que a lista não está vazia

Validam que a imagem contém "http"

Ou seja, só passa se realmente retornar valores da API.

📝 Observações finais

Projeto 100% modular

Estrutura limpa e escalável

Fácil de expandir para outros endpoints

Testes simples, claros e diretos

Segue o padrão Bradesco (logic, steps, runner, feature)