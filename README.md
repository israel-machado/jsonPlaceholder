# Projeto JSON Placeholder

Este projeto utiliza a API RESTful JSONPlaceholder (https://jsonplaceholder.typicode.com) para testar e depurar métodos HTTP que fazem chamadas de API.

A API JSONPlaceholder é uma API de teste que fornece dados falsos para diferentes tipos de solicitações de API. Usando essa API, pode-se prototipar e desenvolver rapidamente aplicativos que precisam de dados falsos para funcionar corretamente. Tentei seguir as boas práticas de codificação ao implementar medidas de segurança, como separação de modulação e gerenciamento de classes de resposta e solicitação.

## Funcionalidades

### Users
- **GET /users**: Retorna todos os usuários.
- **GET /users/{id}**: Retorna um usuário específico com base no ID informado.
- **POST /users**: Cria um novo usuário com base nas informações enviadas no corpo da requisição.
- **PUT /users/{id}**: Atualiza um usuário específico com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /users/{id}**: Remove um usuário específico com base no ID informado e nas informações enviadas no corpo da requisição.

### Posts
- **GET /posts**: Retorna todos os posts.
- **GET /posts/{id}**: Retorna um post específico com base no ID informado.
- **POST /posts**: Cria um novo post com base nas informações enviadas no corpo da requisição.
- **PUT /posts/{id}**: Atualiza um post específico com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /posts/{id}**: Remove um post específico com base no ID informado.

### To-do's
- **GET /todos**: Retorna todas as tarefas (todos).
- **GET /todos/{id}**: Retorna uma tarefa (todo) específica com base no ID informado.
- **POST /todos**: Cria uma nova tarefa (todo) com base nas informações enviadas no corpo da requisição.
- **PUT /todos/{id}**: Atualiza uma tarefa (todo) específica com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /todos/{id}**: Remove uma tarefa (todo) específica com base no ID informado.
- 

### Albums
- **GET /albums**: Retorna todos os álbuns.
- **GET /albums/{id}**: Retorna um álbum específico com base no ID informado.
- **POST /albums**: Cria um novo álbum com base nas informações enviadas no corpo da requisição.
- **PUT /albums/{id}**: Atualiza um álbum específico com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /albums/{id}**: Remove um álbum específico com base no ID informado.

### Photos
- **GET /albums/{albumId}/photos**: Retorna todas as fotos de um álbum específico com base no ID informado.
- **GET /photos/{id}**: Retorna uma foto específica com base no ID informado.
- **POST /photos**: Cria uma nova foto com base nas informações enviadas no corpo da requisição.
- **PUT /photos/{id}**: Atualiza uma foto específica com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /photos/{id}**: Remove uma foto específica com base no ID informado.

### Comments
- **GET /posts/{postId}/comments**: Retorna todos os comentários de um post específico com base no ID informado.
- **GET /comments/{id}**: Retorna um comentário específico com base no ID informado.
- **POST /comments**: Cria um novo comentário com base nas informações enviadas no corpo da requisição.
- **PUT /comments/{id}**: Atualiza um comentário específico com base no ID informado e nas informações enviadas no corpo da requisição.
- **DELETE /comments/{id}**: Remove um comentário específico com base no ID informado.

### Load
- **GET /load**: popula o banco de dados com os dados da JSONPlaceholder(https://jsonplaceholder.typicode.com).

## Explicação sobre algumas abordagens

A API utiliza as seguintes classes para padronizar as respostas e requisições:

- **Response**: classe que padroniza as respostas da API, contendo o status da operação e o objeto de retorno (quando necessário).


- **Request**: interface que padroniza as requisições recebidas pela API, garantindo que todas possuam os mesmos campos.
Também foram criadas as classes **"Domain"** para representar as entidades do banco de dados e **"Placeholder"** para representar as entidades recebidas pelo endpoint de load.

É importante destacar que o uso de classes padronizadas como Response e Request é uma boa prática de desenvolvimento de API, pois ajuda a garantir a consistência e confiabilidade das respostas e requisições.

Além disso, a utilização de classes específicas como **"Domain"** e **"Placeholder"** também pode contribuir para a segurança da API, já que é possível definir com mais precisão quais campos e informações são esperados em cada entidade e endpoint.

Porém, é importante lembrar que a segurança de uma API não depende apenas do uso de classes padronizadas e específicas. É necessário também implementar medidas de segurança adicionais, como autenticação e autorização adequadas, validação de entrada de dados, gerenciamento de erros e outros controles de segurança, para garantir a proteção dos dados e usuários envolvidos.

## Tecnologias Utilizadas
O projeto foi desenvolvido utilizando as seguintes tecnologias:
- Java 17
- Spring Boot 3.0.5
- PostgreSQL
- Postman

### Requisitos
- Java 8 ou superior
- PostgreSQL ou MySQL
- Postman

## Como Rodar o Projeto
1. Clone o repositório:
   ```sh
   git clone https://github.com/israel-machado/jsonPlaceholder.git
   
2. Importe o projeto em uma IDE;
3. Configure o arquivo application.properties com as informações do seu banco de dados local PostgreSQL:
   ```sh
    spring.datasource.url=jdbc:postgresql://localhost:5432/<nome_do_banco>
    spring.datasource.username=<seu_usuario>
    spring.datasource.password=<sua_senha>
    
4. Criar um banco de dados vazio no PostgreSQL (ou MySQL) com o mesmo nome que foi utilizado no arquivo application.properties;
4. Execute o projeto;
5. Acesse a API em ```http://localhost:8080.```
6. Testar as operações da API utilizando ferramentas como o Postman.

## Contribuição
Contribuições são sempre bem-vindas. Para isso, basta criar uma issue ou abrir um pull request.

## Licença
Este projeto está licenciado sob a licença MIT. Consulte o arquivo LICENSE para obter mais informações.


-Projeto desenvolvido por Israel Machado.
