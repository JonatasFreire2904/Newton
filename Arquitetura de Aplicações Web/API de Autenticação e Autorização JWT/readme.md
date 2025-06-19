
# 🔐 API de Autenticação e Autorização JWT - Spring Boot

Este projeto implementa uma API RESTful de autenticação e autorização usando **Spring Boot 3**, **JWT**, **Spring Security**, **Swagger**, **H2 Database** e **JMeter para testes de carga**.  
É ideal como ponto central de autenticação em uma arquitetura baseada em microsserviços.

---

## 🚀 Tecnologias e Dependências Utilizadas

- **Spring Boot 3**
- **Spring Security**
- **JWT (JSON Web Token)**
- **Spring OAuth2 Resource Server**
- **Spring Data JPA**
- **Banco de dados H2 (em memória)**
- **Lombok**
- **Swagger (Springdoc OpenAPI)**
- **JUnit 5 & Mockito**
- **Apache JMeter (para testes de carga)**

---

## 📁 Estrutura do Projeto

src/
├── main/
│ ├── java/com/example/authserver/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ ├── service/
│ │ └── config/
│ └── resources/
│ └── application.yml
├── test/
│ └── java/com/example/authserver/
│ └── AuthIntegrationTests.java
jmeter-tests/
└── login_stress_test.jmx

yaml
Copiar
Editar

---

## ⚙️ Como Rodar o Projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
2. Requisitos
Java 17+

Maven 3.8+

IDE (IntelliJ, VS Code ou Spring Tool Suite)

3. Execute a aplicação
bash
Copiar
Editar
./mvnw spring-boot:run
A aplicação será iniciada em http://localhost:8080.

🧪 Testes
Testes de Integração (JUnit)
Execute os testes com:

bash
Copiar
Editar
./mvnw test
🔑 Usuários Padrão Criados no H2
Username	Senha	Role
admin	123456	ADMIN
user	password	USER

💻 Endpoints Disponíveis
Autenticação
POST /auth/login – Gera um token JWT.

POST /auth/validate – Valida um token JWT.

Endpoints Protegidos
GET /api/hello – Requer autenticação.

GET /api/admin – Requer role ADMIN.

🧪 Teste de Carga com JMeter
Instale o JMeter via https://jmeter.apache.org

Execute o arquivo:

bash
Copiar
Editar
cd jmeter-tests
jmeter login_stress_test.jmx
O teste simula múltiplos logins simultâneos e mede o desempenho da API.

📚 Documentação da API (Swagger)
Após iniciar a aplicação, acesse:

Swagger UI: http://localhost:8080/swagger-ui.html

OpenAPI JSON: http://localhost:8080/v3/api-docs

🧠 Segurança
A chave JWT usada é apenas para desenvolvimento. Em produção, use variáveis de ambiente ou serviços de secrets como:

AWS Secrets Manager

HashiCorp Vault

Spring Cloud Config com criptografia

📝 Licença
Projeto licenciado sob a Apache License 2.0.

