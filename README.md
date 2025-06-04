# 🚗 AutoFluxer — API de Controle de Estoque de Veículos

API desenvolvida em **Java + Spring Boot**, responsável por gerenciar o controle de estoque de veículos automotores, com funcionalidades de cadastro, atualização, movimentações (entrada/saída), gerenciamento de clientes e usuários.

---

## 🔗 Link da API Deploy na Render:
➡️ [Acessar API AutoFluxer](https://autofluxerproject.onrender.com)

➡️ **Documentação Swagger:**  
https://autofluxerproject.onrender.com/swagger-ui/index.html

---

## 📑 Funcionalidades

- 🔸 Cadastro, listagem, busca, atualização e deleção de veículos.
- 🔸 Controle de movimentações: entrada e saída dos veículos.
- 🔸 Cadastro de clientes vinculados às movimentações.
- 🔸 Cadastro de usuários do sistema.
- 🔸 Controle de status dos veículos (disponível, vendido, manutenção, etc).
- 🔸 Documentação interativa com Swagger.

---

## 🏗️ Arquitetura do Projeto

- **Java 24**
- **Spring Boot 3.5.0**
- **Spring Data JPA**
- **H2 Database** (banco de dados em memória para testes)
- **Swagger OpenAPI (Springdoc)**
- **Maven**
- **Deploy Render (Docker)**

---

## 🗂️ Estrutura de Diretórios

src
└── main
├── java
│ └── com
│ └── autofluxer
│ ├── controller → Controladores REST (Veiculo, Cliente, Usuario, Movimentacao)
│ ├── model → Modelos/Entidades JPA
│ ├── repository → Interfaces de acesso ao banco (JPA)
│ ├── service → Lógica de negócio (Services)
│ ├── config → Configurações (Swagger)
│ └── AutofluxerApplication.java → Classe principal
└── resources
├── application.properties → Configurações da aplicação
└── static/templates → (Se necessário)

## 🚀 Como Executar Localmente

### ✅ Pré-requisitos:

- Java 21 ou superior (testado com JDK 24)
- Maven instalado na máquina
- Git instalado (opcional)

### ✅ Clone o projeto:

```bash
git clone https://github.com/pedroitl/AutoFluxer.git
cd AutoFluxer

✅ Build do projeto:
bash
Copiar
Editar
mvn clean package
✅ Executar o projeto:
bash
Copiar
Editar
java -jar target/autofluxer-0.0.1-SNAPSHOT.jar
✔️ Acesse no navegador:
http://localhost:8080/swagger-ui/index.html

🧪 Como Testar a API (via Swagger)
Acesse a documentação interativa no Swagger:

bash
Copiar
Editar
http://localhost:8080/swagger-ui/index.html
ou no deploy online:

arduino
Copiar
Editar
https://autofluxerproject.onrender.com/swagger-ui/index.html
➕ Exemplos de Endpoints:
Método	Endpoint	Descrição
GET	/api/veiculos	Listar todos os veículos
POST	/api/veiculos	Cadastrar um veículo
GET	/api/veiculos/{id}	Buscar veículo por ID
PUT	/api/veiculos/{id}	Atualizar veículo
DELETE	/api/veiculos/{id}	Deletar veículo
GET	/api/clientes	Listar clientes
POST	/api/clientes	Cadastrar cliente
...	(Movimentações e Usuários iguais)	

🗄️ Banco de Dados
Utiliza H2 Database (banco em memória).

Acesse o console do H2 (local):

bash
Copiar
Editar
http://localhost:8080/h2-console
Configuração padrão:

JDBC URL: jdbc:h2:mem:autofluxerdb

User: sa

Password: (vazio)

🐳 Deploy com Docker (Render ou local)
✅ Build da imagem Docker:
bash
Copiar
Editar
docker build -t autofluxer-api .
✅ Executar o container:
bash
Copiar
Editar
docker run -p 8080:8080 autofluxer-api
✅ Acesse:
bash
Copiar
Editar
http://localhost:8080/swagger-ui/index.html
🔥 Tecnologias usadas
✅ Java 24

✅ Spring Boot

✅ Maven

✅ Docker

✅ Spring Data JPA

✅ H2 Database

✅ Swagger (SpringDoc OpenAPI)

✅ Render (Deploy Cloud)

🤝 Contribuição
Contribuições são bem-vindas! Sinta-se livre para abrir uma issue ou enviar um pull request.

👨‍💻 Autor
Desenvolvido por Pedro ITL
➡️ GitHub

🏁 Status do projeto
🚀 Projeto em desenvolvimento e funcionando!
✔️ API funcional, endpoints prontos, documentação no Swagger, deploy na Render ativo.
