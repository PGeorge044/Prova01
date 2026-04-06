# 📦 API REST de Gerenciamento de Itens

## 📌 Descrição

Este projeto consiste em uma API REST desenvolvida com **Spring Boot** para gerenciamento de itens.
A API permite realizar operações básicas como criação, consulta e listagem de itens, além de novos endpoints adicionais e validações de regras de negócio.

A aplicação suporta respostas nos formatos **JSON** e **XML**.

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Web
* JUnit 5
* MockMvc
* Jackson (JSON/XML)
* JaCoCo (cobertura de testes)

---

## 📂 Estrutura do Projeto

```
src/
 ├── main/java/com/example/demo/
 │    ├── controller/        # Endpoints da API
 │    ├── service/           # Regras de negócio
 │    ├── model/             # Entidade Item
 │    ├── exception/         # Exceções customizadas
 │
 ├── test/java/com/example/demo/
 │    ├── ApiControllerTest  # Testes da API
```

---

## 🔗 Endpoints Disponíveis

### 📌 Endpoints principais

| Método | Endpoint          | Descrição          |
| ------ | ----------------- | ------------------ |
| GET    | `/api/items/{id}` | Buscar item por ID |
| POST   | `/api/items`      | Criar novo item    |

---

### 🚀 Novos endpoints implementados

| Método | Endpoint                  | Descrição                           |
| ------ | ------------------------- | ----------------------------------- |
| GET    | `/api/items/search?name=` | Buscar itens pelo nome              |
| GET    | `/api/items/count`        | Retorna a quantidade total de itens |

---

## ⚠️ Regras de Negócio

As seguintes regras foram implementadas e testadas:

### ✔️ Validações obrigatórias

* O **nome do item**:

    * Não pode ser nulo
    * Não pode ser vazio

* A **descrição do item**:

    * Não pode ser nula
    * Não pode ser vazia

---

### ❌ Cenários de erro

A API lança a exceção customizada:

`InvalidItemDataException`

Nos seguintes casos:

* Nome nulo ou vazio
* Descrição nula ou vazia
* Parâmetro de busca inválido

Esses erros retornam:

```
HTTP 400 - Bad Request
```

---

### ✔️ Cenários de sucesso

* Criar item válido → `201 Created`
* Buscar item existente → `200 OK`
* Buscar item inexistente → `404 Not Found`
* Buscar por nome válido → `200 OK`
* Contar itens → `200 OK`

---

## 🧪 Testes

Foram implementados testes unitários utilizando **JUnit 5** e **MockMvc**, cobrindo:

### ✔️ Testes de sucesso

* Criação de item válido
* Consulta de item existente
* Busca por nome
* Contagem de itens

### ❌ Testes de falha

* Nome vazio
* Nome nulo
* Descrição vazia
* Item não encontrado
* Parâmetros inválidos

---

## 📊 Cobertura de Testes

A cobertura de testes foi gerada utilizando o **JaCoCo**.

Para visualizar o relatório:

```
target/site/jacoco/index.html
```

Um print do relatório foi incluído na entrega.

---

## ▶️ Como Executar o Projeto

### 🔧 Pré-requisitos

* Java 17+ (ou compatível)
* Maven

---

### ▶️ Executar a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080/api/items
```

---

### 🧪 Executar os testes

```bash
mvn test
```

---

### 📊 Gerar relatório de cobertura

```bash
mvn clean test
```

Depois abrir:

```
target/site/jacoco/index.html
```

---

## 📌 Observações Finais

Este projeto foi desenvolvido com foco em:

* Boas práticas de API REST
* Validação de dados
* Tratamento de exceções
* Cobertura de testes
* Organização de código em camadas

---

## 👨‍💻 Autor

Paulo George da Cruz Araújo Filho.

<img width="837" height="292" alt="image" src="https://github.com/user-attachments/assets/ad0bc276-917b-4dc5-be17-0f2dd050a9b7" />

<img width="1643" height="638" alt="image" src="https://github.com/user-attachments/assets/5a5f86bd-a3c8-4cb7-a962-19473967ca8a" />


