# ms-proposta

## Integrantes
- Igor Koppen Pasqualino Pereira

## Descrição do Projeto
O projeto **ms-proposta** é um microserviço desenvolvido como parte do checkpoint 1 da matéria de microsserviços.
A aplicação tem como finalidade gerenciar propostas e
usuários, permitindo a criação, consulta, atualização
e exclusão de dados relacionados a propostas e usuários.

## Stacks Utilizadas
- **Java 17**: Linguagem de programação utilizada para o desenvolvimento do projeto.
- **Spring Boot 3.3.3**: Framework utilizado para simplificar o desenvolvimento de microserviços, fornecendo uma estrutura robusta e flexível.
    - **Spring Data JPA**: Para interação com o banco de dados.
    - **Spring Validation**: Para validação dos dados de entrada.
    - **Spring Web**: Para criação de APIs RESTful.
- **H2 Database**: Banco de dados em memória utilizado para facilitar o desenvolvimento e testes.
- **Maven**: Gerenciador de dependências e build.

## Endpoints Disponíveis

### PropostaController
- `GET /propostas`: Retorna uma lista de todas as propostas.
- `GET /propostas/{id}`: Retorna os detalhes de uma proposta específica pelo ID.
- `POST /propostas`: Cria uma nova proposta junto com usuário novo.

### UserController
- `GET /Users`: Retorna uma lista de todos os usuários.
- `GET /Users/{id}`: Retorna os detalhes de um usuário específico pelo ID.
- `POST /Users`: Cria um novo usuário.
- `PUT /Users/{id}`: Atualiza os dados de um usuário específico.
- `DELETE /Users/{id}`: Exclui um usuário pelo ID.

## Como Executar o Projeto

1. Certifique-se de ter o [JDK 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) instalado.
2. Clone o repositório do projeto ou baixe o projeto.
3. Navegue até o diretório raiz do projeto.
4. Execute o comando `mvn spring-boot:run` para iniciar o microserviço.
5. A aplicação estará disponível em `http://localhost:8080`.