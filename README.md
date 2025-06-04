# global-solution-api

> API RESTful para comunicação offline em situações de emergência com rede mesh e sincronização via backend.

## Descrição do Projeto

Em cenários de desastres naturais ou falta de internet, a comunicação é um dos maiores desafios para equipes de resgate e apoio. O projeto propõe uma solução inovadora para permitir a comunicação offline entre dispositivos móveis, com posterior sincronização para um backend central.

Este projeto visa:

- ✅ Troca de mensagens offline via rede mesh local entre dispositivos móveis (Bluetooth Mesh, LoRa etc.);
- ✅ Sincronização de dados com o backend quando houver conexão disponível;
- ✅ Armazenamento centralizado de informações para auditoria, análise e apoio às equipes de emergência;
- ✅ Gerenciamento completo via API RESTful construída em Java Spring Boot, seguindo boas práticas de arquitetura, documentação (Swagger/OpenAPI), uso de DTOs, cache e tratamento de erros.

A API será consumida por um aplicativo móvel que permitirá:

- Feed inicial com posts informativos — exibindo posts criados por usuários verificados como "socorristas", que poderão fornecer informações importantes durante desastres (como alertas, bloqueios de vias, pontos de apoio e recursos emergenciais).
- Área de mensagens — onde o usuário pode buscar outros usuários (por nome) e enviar mensagens diretas, mesmo em ambiente offline (rede mesh).
- **Tela de perfil** — com opções para:
    - Atualizar nome e senha;
    - Solicitar verificação de tipo de usuário para se tornar um "socorrista" e, assim, poder criar posts informativos no feed;
- Consulta interativa de alertas, mensagens e localização em tempo real (quando sincronizado com o servidor).

---

## Tecnologias e Ferramentas Utilizadas

- **Java 17**
- **Spring Boot 3**
- **Maven**
- **Docker e Docker Compose**

### Módulos Spring Utilizados

- **Spring Web** — construção da API RESTful
- **Spring Data JPA** — persistência de dados com ORM
- **Spring Validation** — validação de dados de entrada
- **Spring Security** — autenticação e autorização com JWT
- **Spring Cache** — melhoria de performance com cache de dados
- **MapStruct** — mapeamento automático entre entidades e DTOs

---

## Persistência de Dados

- **Oracle Database** 

---

## Documentação e Testes da API

- **Swagger/OpenAPI** — documentação da API
- **Swagger UI** — testes via interface interativa
- **Postman** — testes manuais

---
## Como Executar

⚠️ Após clonar o repositório, é necessário criar o arquivo `.env` na raiz do projeto com as variáveis de ambiente necessárias para a aplicação funcionar corretamente.

Exemplo de conteúdo do arquivo `.env`:
```env
DB_USERNAME=usuario
DB_PASSWORD=senha
```

### Executando com Maven

```bash
# Clone o repositório
git clone https://github.com/thiag0renatino/global-solution-api.git
cd global-solution-api

# Compile o projeto
mvn clean install

# Execute a aplicação
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

### Executando com Docker Compose

- Execute os containers:

```bash
docker-compose up --build
```

A aplicação e o banco de dados serão inicializados e expostos nas portas configuradas.

---

## Documentação da API

Disponível via Swagger:

```
http://localhost:8080/swagger-ui/index.html
```

## Autenticação

> **Observação:** Para testar os endpoints protegidos, é necessário realizar login na API.

1. Use os endpoints:
   - `POST /auth/register` — para registrar um usuário;
   - `POST /auth/login` — para autenticar e obter o token JWT.

2. Após o login, copie o token JWT e adicione no Swagger UI clicando em "Authorize" (ícone de cadeado) e colando o token.

---

## Principais Entidades

| Entidade                 | Descrição                                                                                   |
|--------------------------|---------------------------------------------------------------------------------------------|
| **Usuario**              | Usuário cadastrado (nome, email, senha, tipo de usuário: COMUM ou SOCORRISTA)                |
| **Dispositivo**          | Dispositivo móvel cadastrado (UUID, vinculado ao usuário)                                   |
| **Localizacao**          | Posição geográfica de um dispositivo (latitude, longitude, data de captura)                  |
| **Mensagem**             | Mensagem trocada entre dispositivos (conteúdo, origem, destino, sincronizado)               |
| **Post**                 | Postagens de informações de alerta                                                          |
| **SolicitacaoTipoUsuario** | Solicitações de verificação de tipo de usuário (SOCORRISTA)                                  |

---

##  Endpoints da API

> **Nota:** Todos os endpoints protegidos requerem autenticação via JWT.

### Authentication
- `POST /auth/register`
- `POST /auth/login`

### Usuario Controller
- `GET /usuarios`
- `GET /usuarios/{id}`
- `GET /usuarios/buscar`
- `PUT /usuarios/{id}/atualizar-senha`
- `PUT /usuarios/{id}/atualizar-nome`

### Dispositivo Controller
- `GET /dispositivos`
- `GET /dispositivos/{id}`
- `POST /dispositivos`
- `PUT /dispositivos/{id}`
- `DELETE /dispositivos/{id}`

### Localizacao Controller
- `GET /localizacoes`
- `GET /localizacoes/{id}`
- `POST /localizacoes`
- `PUT /localizacoes/{id}`
- `DELETE /localizacoes/{id}`

### Mensagem Controller
- `GET /mensagens`
- `GET /mensagens/{id}`
- `GET /mensagens/paginado`
- `GET /mensagens/offline`
- `POST /mensagens`
- `PUT /mensagens/{id}/marcar-sincronizada`
- `DELETE /mensagens/{id}`

### Post Controller
- `GET /posts`
- `GET /posts/{id}`
- `GET /posts/paginado`
- `POST /posts`
- `PUT /posts/{id}`
- `DELETE /posts/{id}`

### SolicitacaoTipoUsuario Controller
- `GET /usuarios/{idUsuario}/solicitacoes-verificacao`
- `POST /usuarios/{idUsuario}/solicitacoes-verificacao`

---

## Alunos

- Thiago Renatino Paulino — RM556934
- Cauan Matos Moura — RM558821
- Gustavo Roberto — RM558033

---

## Licença

Projeto acadêmico — FIAP 2025.
