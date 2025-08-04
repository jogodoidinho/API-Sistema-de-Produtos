# 🛠️ API - Sistema de Produtos

Uma API REST desenvolvida em **Java com Spring Boot** para gerenciamento de **produtos, pedidos, clientes e categorias**, baseada no curso do professor **Nélio Alves**.

---

## 🔗 Endpoints disponíveis

### 📥 Métodos `GET`

- `GET /users`  
  Retorna **todos os usuários** cadastrados no banco de dados.

- `GET /users/{id}`  
  Retorna o **usuário com o ID especificado**.

- `GET /orders`  
  Retorna **todos os pedidos** registrados.

- `GET /orders/{id}`  
  Retorna o **pedido com o ID especificado**.

- `GET /products`  
  Retorna **todos os produtos** disponíveis.

- `GET /products/{id}`  
  Retorna o **produto com o ID especificado**.

- `GET /categories`  
  Retorna **todas as categorias** cadastradas.

- `GET /categories/{id}`  
  Retorna a **categoria com o ID especificado**.

---

### ➕ Métodos `POST`

- `POST /users`  
  Insere **um novo usuário** no banco de dados.

- `POST /products`  
  Insere **um novo produto** no sistema (com validação).

- `POST /categories`  
  Cria **uma nova categoria** de produto (com validação).

---

### ✏️ Métodos `PUT`

- `PUT /users/{id}`  
  Atualiza os **atributos** do usuário com o ID informado.

- `PUT /products/{id}`  
  Altera **apenas o preço** de um produto específico.  
  Espera um JSON no formato:  
  ```json
  { "price": 199.90 }
  ```

- `PUT /products`  
  Atualiza **todos os dados** de um produto existente (com validação).

---

### 🗑️ Métodos `DELETE`

- `DELETE /users/{id}`  
  Deleta o usuário com o ID especificado.  
  ⚠️ Caso o usuário tenha **pedidos em aberto**, a exclusão será **bloqueada** e será retornada uma **exceção personalizada**.

- `DELETE /categories/{id}`  
  Remove a categoria com o ID especificado.

---

## 📚 Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- H2 / PostgreSQL
- Maven
