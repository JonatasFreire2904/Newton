🌟 Avaliação Prática: Persistência com Spring Boot 🏆
📝 Descrição
Bem-vindo ao projeto Times e Jogadores! 🚀 Esta é uma aplicação Spring Boot que gerencia times e jogadores de futebol, com um relacionamento @ManyToOne (muitos jogadores pertencem a um time). Construída com MariaDB, ela utiliza Spring Data JPA, Lombok, Spring Web e DevTools para oferecer uma experiência de persistência de dados eficiente e moderna. ⚽
🗂 Estrutura do Projeto
O projeto está organizado em camadas claras para facilitar a manutenção e escalabilidade:

📋 Models: Entidades Jogador e Time, anotadas com JPA para mapeamento no banco de dados.
🗄 Repositories: Interfaces JogadorRepository e TimeRepository, que extendem JpaRepository para operações CRUD.
⚙️ Services: Lógica de negócio em JogadorService e TimeService, garantindo operações seguras e reutilizáveis.
🌐 Controllers: Endpoints REST em JogadorController e TimeController, expondo funcionalidades via API.

🔗 Relacionamento entre Entidades
O coração do projeto é o relacionamento entre as entidades:

⚽ Jogador: Cada jogador pertence a um time, mapeado com @ManyToOne e uma chave estrangeira time_id na tabela jogador. Usa @JsonBackReference para evitar loops de serialização.
🏟 Time: Um time pode ter vários jogadores, configurado com @OneToMany(mappedBy = "time") e @JsonManagedReference para gerenciar a lista de jogadores.
No banco, a tabela jogador tem a coluna time_id referenciando a tabela time, garantindo integridade relacional. 🛠

🚀 Como Executar
Siga os passos abaixo para rodar o projeto localmente:

Instale o XAMPP 📦

Baixe e instale o XAMPP para usar o MariaDB.
Inicie o serviço MariaDB na porta padrão 3306.


Crie o Banco de Dados 🗄

Acesse o MariaDB via terminal ou phpMyAdmin e crie o banco av1:CREATE DATABASE av1;




Configure o Projeto ⚙️

Abra o arquivo src/main/resources/application.properties e verifique as configurações:spring.datasource.url=jdbc:mariadb://localhost:3306/av1
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update


Ajuste o username e password conforme sua configuração do MariaDB.


Execute a Aplicação 🏃‍♂️

Na raiz do projeto, rode:mvn spring-boot:run


A aplicação estará disponível em http://localhost:8080.


Explore os Dados Iniciais 📊

Na pasta Estrutura Banco de Dados, há um arquivo exportado com exemplos de inserções para as tabelas time e jogador. Use-o como referência para popular o banco manualmente ou via phpMyAdmin.



🧪 Testes com Postman
Para testar os endpoints, usamos o Postman! 🛠

Instale o Postman 📬

Baixe o Postman ou use a versão online.


Importe a Coleção 📂

Na pasta postman, você encontrará o arquivo de coleção (*.postman_collection.json).
No Postman, clique em Import e selecione o arquivo para carregar todos os endpoints.


Teste os Endpoints 🚀

Execute requisições para criar, listar, atualizar e deletar times e jogadores. Exemplos:
POST http://localhost:8080/time (criar time):{
    "nome": "Flamengo"
}


POST http://localhost:8080/jogador (criar jogador):{
    "nome": "Gabigol",
    "posicao": "Atacante",
    "idade": 28,
    "time": { "id": 1 }
}






Valide no Banco 🔍

Use o phpMyAdmin ou o terminal para verificar os dados:SHOW TABLES;
DESCRIBE time;
DESCRIBE jogador;
SELECT * FROM time;
SELECT * FROM jogador WHERE time_id = 1;





🌐 Endpoints Disponíveis
Aqui estão os endpoints REST para interagir com a aplicação:
Time 🏟

GET /time: Lista todos os times.
POST /time: Cria um novo time (retorna 201 Created).
GET /time/{id}: Busca um time por ID (retorna 404 se não encontrado).
PUT /time/{id}: Atualiza um time existente.
DELETE /time/{id}: Deleta um time (retorna 204 No Content).

Jogador ⚽

GET /jogador: Lista todos os jogadores.
POST /jogador: Cria um novo jogador (retorna 201 Created).
GET /jogador/{id}: Busca um jogador por ID (retorna 404 se não encontrado).
PUT /jogador/{id}: Atualiza um jogador existente.
DELETE /jogador/{id}: Deleta um jogador (retorna 204 No Content).

✅ Validação do Relacionamento
Para garantir que o relacionamento @ManyToOne está funcionando:

Crie um time e associe jogadores a ele via Postman.
Verifique no MariaDB se a coluna time_id na tabela jogador referencia corretamente o ID do time.
Teste listar jogadores de um time específico (você pode adicionar um endpoint extra, se quiser, como GET /time/{id}/jogadores).

🛠 Tecnologias Utilizadas

Spring Boot 3.4.4 🚀
MariaDB 10.4 🗄
Spring Data JPA 📋
Lombok ✨
Spring Web 🌐
DevTools 🔧

📚 Notas Finais
Este projeto foi desenvolvido para a Avaliação Prática de Persistência de Dados e cumpre todos os requisitos:

Relacionamento funcional entre Time e Jogador.
CRUD completo para ambas as entidades.
Uso de Lombok para simplificar o código.
Endpoints REST testados com Postman.
Persistência validada no MariaDB.

Se precisar de ajuda para rodar, testar ou adicionar mais funcionalidades, é só avisar! 😊
Desenvolvido por Jonatas Freire 💻
