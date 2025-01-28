# CRUD com Spring Boot, PostgreSQL e Front-end Responsivo

Este repositório contém um projeto completo de CRUD (Create, Read, Update, Delete) desenvolvido com Spring Boot no back-end, PostgreSQL como banco de dados relacional e um front-end responsivo com Bootstrap. O objetivo é demonstrar habilidades práticas em desenvolvimento full-stack, integrando tecnologias modernas para criar um sistema funcional e escalável.

## **Tecnologias Utilizadas**

### **Back-end**
- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework robusto para criação de APIs RESTful.
- **Spring Data JPA**: Gerenciamento de persistência e consultas ao banco de dados.
- **PostgreSQL**: Banco de dados relacional para armazenamento eficiente e seguro.
- **Controle de Injeção de Dependências (CDI)**: Para modularidade e desacoplamento.

### **Front-end**
- **HTML5** e **CSS3**: Estrutura e estilo das páginas.
- **Bootstrap 5**: Design responsivo e componentes pré-estilizados.
- **JavaScript/jQuery**: Para lógica interativa e comunicação com a API via AJAX.

## **Funcionalidades Principais**
- **Cadastro de Usuários**: Criação de novos registros com nome e idade.
- **Listagem de Usuários**: Exibição de todos os usuários cadastrados.
- **Edição de Usuários**: Atualização de informações existentes.
- **Exclusão de Usuários**: Deleção segura de registros pelo ID.
- **Busca por Nome**: Consulta eficiente de usuários pelo nome.

## **Pré-requisitos**
- **Java 11** ou superior
- **Maven** para gerenciamento de dependências
- **PostgreSQL** instalado e configurado
- **IDE de sua preferência** (Eclipse, IntelliJ, etc.)

## **Como Executar o Projeto**

### **1. Clone o Repositório**
```bash
https://github.com/VitordevJava/CrudSpringBoot.git
```

### **2. Configure o Banco de Dados**
- Crie um banco de dados PostgreSQL com o nome desejado.
- Atualize as credenciais no arquivo `application.properties` localizado em `src/main/resources/`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### **3. Compile e Execute o Back-end**
- Abra o terminal na pasta raiz do projeto.
- Execute o comando:
```bash
mvn spring-boot:run
```
O servidor será iniciado em: `http://localhost:8080`

### **4. Utilize o Front-end**
- Abra o arquivo `index.html` localizado na pasta `src/main/resources/static` em seu navegador.
- Utilize os botões e formulários para interagir com as funcionalidades do sistema.

## **Endpoints da API**

| Método   | Endpoint              | Descrição                         |
|----------|-----------------------|-----------------------------------|
| GET      | `/listatodos`         | Lista todos os usuários.          |
| POST     | `/salvar`             | Salva um novo usuário.            |
| PUT      | `/atualizar`          | Atualiza um usuário existente.    |
| DELETE   | `/delete?iduser={id}` | Deleta um usuário pelo ID.        |
| GET      | `/buscarUserid?iduser={id}` | Busca um usuário pelo ID.        |
| GET      | `/buscarPorNome?name={nome}` | Busca usuários pelo nome.       |

## **Capturas de Tela**

### Cadastro de Usuários
![Tela de Cadastro](https://via.placeholder.com/800x400?text=Tela+de+Cadastro)

### Listagem de Usuários
![Listagem de Usuários](https://via.placeholder.com/800x400?text=Listagem+de+Usu%C3%A1rios)

## **Contribuições**
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e enviar pull requests.

## **Licença**
Este projeto está licenciado sob a [MIT License](LICENSE).

