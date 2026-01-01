# CRM JDBC CRUD Project

A simple **CRUD application** using **Java + JDBC + MySQL** demonstrating a minimal Client Management System.

---

## 🚀 Tecnologias Utilizadas
- Java 17+
- JDBC
- MySQL
- DAO Pattern

---

## 📂 Estrutura do Projeto

```text
src/
└─ com.crm.jdbc
   ├─ 🧠 application
   │  └─ Main.java
   ├─ 🗂️ dao
   │  └─ ClientDAO.java
   ├─ 📦 model
   │  └─ Client.java
   └─ ⚠️ exception
      └─ DatabaseException.java
```

---

## 🧠 Funcionalidades (CRUD)
| Método | Descrição |
|--------|------------|
| `insert(Client c)` | Cadastra um novo cliente |
| `findAll()` | Lista todos os clientes |
| `findById(int id)` | Busca por ID |
| `updateEmail(int id, String email)` | Atualiza o email |
| `deleteById(int id)` | Remove cliente por ID |

---

## 🛢️ Script do Banco de Dados
```sql
CREATE DATABASE crm_jdbc;

USE crm_jdbc;

CREATE TABLE client (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);
```

---

## 🔌 Configuração da Conexão

A classe DBConfig contém as credenciais de acesso ao MySQL.
Certifique-se de ajustar para seu ambiente local:

```
private static final String URL = "jdbc:mysql://localhost:3306/crm_jdbc";
private static final String USER = "root";
private static final String PASSWORD = "sua_senha";
```

----


## 🎯 Demonstração do CRUD

Basta rodar o Main.java para executar automaticamente todas as operações CRUD no banco.

```
--- INSERT ---
Client inserted!

--- FIND ALL ---
1 | Johnny Test | johnnytest@gmail.com

--- FIND BY ID (1) ---
Johnny Test found!

--- UPDATE EMAIL ---
Email updated!

--- DELETE BY ID ---
Client deleted!

CRUD executed successfully!
```

--- 

## ▶️ Como Executar

1. Clone este repositório
2. Configure o banco de dados usando o script acima
3. Ajuste as credenciais no arquivo `DBConfig.java`
4. Adicione o driver JDBC do MySQL ao classpath
5. Execute a classe `Main.java`



