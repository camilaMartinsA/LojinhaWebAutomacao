## Lojinha  Web Automação

Esse é um repositório que contém a automação de alguns testes Web de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

##  Tecnologias Utilizadas

-   Java  [https://www.oracle.com/java/technologies/downloads](https://www.oracle.com/java/technologies/downloads)
-  Chrome driver  https://chromedriver.chromium.org/downloads
-  Junit Maven https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api


## Testes Automatizados

Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.



## Notas Gerais

-   Sempre utilizamos a anotação Before Each para capturar o WebDriver que será utilizado posteriormente nos métodos de teste.
-   Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes
- Foi ultilizado o Web Driver uma biblioteca de interação que é capaz de abrir o browser e navegar na tela  de modo a simular o usuário real. 
