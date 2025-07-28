# 🛠️ API - Sistema de Produtos

Uma API REST desenvolvida em **Java com Spring Boot** para gerenciamento de **produtos, pedidos, clientes e categorias**, baseada no curso do professor **Nélio Alves**.

---

## 🔗 Endpoints disponíveis

### 📥 Métodos `GET`

- `GET /users`  
  Retorna **todos os usuários** cadastrados no banco de dados.

- `GET /users/{id}`  
  Retorna o **usuário com o ID especificado**.

---

### ➕ Métodos `POST`

- `POST /users`  
  Insere **um novo usuário** no banco de dados.

---

### 🗑️ Métodos `DELETE`

- `DELETE /users/{id}`  
  Deleta o usuário com o ID especificado.  
  ⚠️ Caso o usuário tenha **pedidos em aberto**, a exclusão será **bloqueada** e será retornada uma **exceção personalizada**.

---

### ✏️ Métodos `PUT`

- `PUT /users/{id}`  
  Atualiza os **atributos** do usuário com o ID informado.

---

## 📚 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL
- Maven
