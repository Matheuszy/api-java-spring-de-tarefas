# 📝 API de Tarefas - Spring Boot

Este projeto é uma API simples para gerenciamento de tarefas desenvolvida em **Java com Spring Boot**.  
Além da API, também existe um cliente em linha de comando (CLI) que interage com a aplicação para cadastrar e gerenciar tarefas.

---

## 🚀 Funcionalidades

- **Listar tarefas** → `GET /lista-tarefas`
- **Criar nova tarefa** → `POST /tarefas`
- **Deletar tarefa** → `DELETE /deleta-tarefas`
- **Cliente CLI (Main.java)** → Permite inserir tarefas diretamente pelo terminal, validando datas e enviando para a API.

---

## 📂 Estrutura do Projeto

src/
└── main/
├── java/
│ └── tech/tarefas/api/
│ ├── controller/ControllerApi.java # Controlador da API
│ ├── main/Main.java # Cliente CLI que consome a API
│ ├── modelo/Tarefa.java # Classe de modelo (entidade Tarefa)
│ └── ApiApplication.java # Classe principal do Spring Boot
└── resources/
└── application.properties # Configurações da aplicação


---

## 📡 Endpoints

### 🔹 Listar Tarefas
GET http://localhost:8080/lista-tarefas


**Resposta:**
```json
[
  "Tarefa{nome='Estudar Spring', descricao='Praticar API', dataInicio=2025-10-06, dataTermino=2025-10-07}"
]

POST http://localhost:8080/tarefas

{
  "nome": "Estudar Java",
  "descricao": "Revisar Streams e Lambdas",
  "dataInicio": "10/10/2025",
  "dataTermino": "15/10/2025"
}


DELETE http://localhost:8080/deleta-tarefas

{
  "nome": "Estudar Java"
}


git clone https://github.com/seu-usuario/api-tarefas.git
cd api-tarefas


./mvnw spring-boot:run

🛠 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Web

RestTemplate

Maven