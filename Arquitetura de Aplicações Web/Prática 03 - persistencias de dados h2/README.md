Prática 03 - Persistência de Dados com SQL
Sobre o Projeto
Este projeto é uma API REST desenvolvida com Spring Boot para gerenciamento de tarefas. Ele permite criar, listar, atualizar e excluir tarefas, utilizando um banco de dados H2 em memória para persistência. A API é documentada com Swagger (via springdoc-openapi) e inclui validações de entrada, tratamento de erros e uma interface para visualização do banco H2.
Funcionalidades

Criar Tarefa: Adiciona uma nova tarefa com título, descrição, status e data de criação.
Listar Tarefas: Retorna todas as tarefas cadastradas.
Atualizar Tarefa: Permite modificar uma tarefa existente pelo ID.
Excluir Tarefa: Remove uma tarefa pelo ID.

Tecnologias Utilizadas

Java 17+
Spring Boot 3.x
H2 Database (banco em memória)
Spring Data JPA (para persistência)
springdoc-openapi (para documentação da API com Swagger)
Lombok (para reduzir código boilerplate)

Pré-requisitos
Antes de rodar o projeto, certifique-se de ter instalado:

Java 17 ou superior
Maven (para gerenciar dependências e build)
Um editor de código (ex.: IntelliJ IDEA, VS Code)

Como Rodar o Projeto

Clone o Repositório:
git clone https://github.com/seu-usuario/pratica-03-persistencia-de-dados-sql.git
cd pratica-03-persistencia-de-dados-sql


Compile e Instale as Dependências:Execute o comando Maven para baixar as dependências e compilar o projeto:
mvn clean install


Execute a Aplicação:Inicie o servidor Spring Boot:
mvn spring-boot:run

A aplicação estará rodando em http://localhost:8080.


Acessando o Swagger UI
O Swagger UI permite explorar e testar os endpoints da API de forma interativa.

Com a aplicação rodando, acesse:http://localhost:8080/swagger-ui.html


No Swagger UI, você verá todos os endpoints disponíveis:
GET /tarefas: Lista todas as tarefas.
POST /tarefas: Cria uma nova tarefa.
PUT /tarefas/{id}: Atualiza uma tarefa existente.
DELETE /tarefas/{id}: Exclui uma tarefa.


Use o botão "Try it out" para testar os endpoints diretamente no navegador.

Acessando o Console H2
O banco H2 em memória pode ser acessado para visualizar e gerenciar os dados das tarefas.

Com a aplicação rodando, acesse:http://localhost:8080/h2-console


Configure os dados de conexão no console H2:
JDBC URL: jdbc:h2:mem:tarefas
Username: sa
Password: (deixe em branco)


Clique em "Connect".
Você verá a tabela TAREFA criada automaticamente pelo Hibernate. Execute consultas SQL como SELECT * FROM TAREFA; para visualizar os dados.

Estrutura do Projeto

Controller: Contém os endpoints REST (TarefaController).
Model: Define a entidade Tarefa e o DTO TarefaCreateDTO.
Service: Lógica de negócio (TarefaService).
Repository: Interface para acesso ao banco (TarefaRepository).
application.properties: Configurações do Spring Boot, H2 e Hibernate.

Exemplo de Uso
Criar uma Tarefa
Use o Swagger UI ou uma ferramenta como Postman para enviar uma requisição POST:
POST http://localhost:8080/tarefas
Content-Type: application/json

{
    "titulo": "Minha Tarefa",
    "descricao": "Descrição da tarefa",
    "status": "Em andamento"
}


Resposta esperada: Status 201 Created com os dados da tarefa criada, incluindo o id gerado.

Listar Tarefas
GET http://localhost:8080/tarefas


Resposta esperada: Lista de tarefas no formato JSON.

Notas

O banco H2 é em memória, então os dados são perdidos ao reiniciar a aplicação.
Para ambientes de produção, considere usar um banco persistente (ex.: PostgreSQL) e ferramentas de migração como Flyway ou Liquibase.
Adicione testes unitários e de integração para aumentar a confiabilidade da aplicação.

Contribuição

Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b feature/nova-funcionalidade).
Commit suas mudanças (git commit -m 'Adiciona nova funcionalidade').
Envie para o repositório remoto (git push origin feature/nova-funcionalidade).
Abra um Pull Request.

Licença
Este projeto está licenciado sob a MIT License.

