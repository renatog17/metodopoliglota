# KitCard – Backend (Java 21 + Spring Boot)

Este é o backend do projeto **KitCard**, um aplicativo de flashcards para aprendizado de idiomas.  
A API foi construída seguindo boas práticas de arquitetura, segurança e validação, utilizando **Java 21** e **Spring Boot 3 / Spring Framework 6**.

## Related Repositories

- Frontend: [Método Poliglota](https://github.com/renatog17/metodopoliglota-front)

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Spring Security**
- **Spring Data JPA**
- **Spring Validation**
- **Hibernate**
- **PostgreSQL**
- **Lombok**
- **Maven**

---

## 📌 Funcionalidades da API

### ✔️ Autenticação e Autorização
- Registro de usuário
- Login com geração de token JWT
- Validação automática de credenciais
- Acesso seguro a rotas autenticadas
- Integração com Spring Security

### ✔️ Gestão de Decks
- Criar decks
- Listar decks do usuário autenticado
- Buscar deck por ID
- Atualizar deck
- Excluir deck

### ✔️ Gestão de Lexemes (Flashcards)
- Criar termos associados a um deck
- Listagem de lexemes por deck
- Atualização e remoção
- Validação de entrada com Bean Validation

### ✔️ Estruturação em DTOs
- Uso de DTOs para entrada/saída
- Conversões limpas com construtores e mapeamentos
- Separação total entre entidade e transporte

### ✔️ Tratamento de Erros
- `@RestControllerAdvice` com retorno padronizado via `ApiError`
- Suporte para erros de validação (400)
- Erros de conflito (409)
- Erros de autenticação (401)
- Erros de acesso negado (403)
- Erros de recurso não encontrado (404)

