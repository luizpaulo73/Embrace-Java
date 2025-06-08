# Embrace  
*Conectando solidariedade e tecnologia para salvar vidas em desastres extremos*

### Rafael de Souza Pinto - RM 555130  
### Luiz Paulo Freitas Fernandes - RM 555497  
### Enzo Marsola - RM 556310  

---
<p align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.2.5-blue.svg" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Java-17-orange.svg" alt="Java 17"/>
  <img src="https://img.shields.io/badge/License-MIT-green.svg" alt="License"/>
</p>

---

## 🔗 Sumário

| Seção                         | Link                                                                 |
|-------------------------------|----------------------------------------------------------------------|
| Descrição do Projeto          | [Descrição do Projeto](#descricao-do-projeto)                       |
| Problemas Identificados       | [Problemas Identificados](#problemas-identificados)                 |
| Solução Proposta              | [Solução Proposta](#solucao-proposta)                               |
| Benefícios                    | [Benefícios](#beneficios)                                           |
| Arquitetura                   | [Arquitetura](#arquitetura)                                         |
| Funcionalidades & Testes      | [Funcionalidades & Testes](#funcionalidades--testes)                |
| Como Executar                 | [Como Executar](#como-executar) 


<a id="descricao-do-projeto"></a>
## 📖 Descrição do Problema

Nos últimos anos, o mundo tem testemunhado um crescimento alarmante na frequência e intensidade de desastres naturais, como enchentes, ondas de calor e deslizamentos de terra. O Brasil, em especial, registrou **1.161 ocorrências apenas em 2023**, afetando **milhões de pessoas** e causando prejuízos econômicos superiores a **R$ 50 bilhões**.

Apesar da urgência, a **resposta emergencial ainda é fragmentada**: ONGs, voluntários e órgãos públicos atuam por canais distintos, dificultando a **distribuição eficiente de recursos**, atrasando o socorro e aumentando o sofrimento das populações vulneráveis.

---

<a id="problemas-identificados"></a>
## 🛑 Problemas Identificados

1. **Ações descentralizadas**: ONGs, voluntários e autoridades operam por canais não integrados (WhatsApp, redes sociais, sites), gerando retrabalho e má distribuição de recursos.  
2. **Ausência de visibilidade em tempo real**: Falta um painel único que mostre onde a ajuda é mais necessária, o que atrasa decisões críticas.  
3. **Doações mal distribuídas**: Algumas regiões recebem excesso de doações enquanto outras, igualmente afetadas, ficam desassistidas.  
4. **Comunicação ineficiente**: Famílias e comunidades afetadas enfrentam dificuldades para encontrar locais de apoio, pontos de doação ou ações solidárias.  
5. **Falta de prevenção baseada em dados**: Órgãos públicos e ONGs carecem de sistemas inteligentes para antecipar riscos com base em informações ambientais.

---

<a id="solucao-proposta"></a>
## 🚀 Solução Proposta

**Embrace** é uma plataforma digital que unifica todos os atores envolvidos na resposta a desastres — ONGs, voluntários, doadores e comunidades afetadas — em um só lugar. A solução combina **tecnologia, solidariedade e dados em tempo real** para tornar a resposta a eventos extremos mais rápida, eficaz e justa.

> Com Java, garantimos **robustez no back-end**, **modularidade nas funcionalidades** e **agilidade nas respostas**, especialmente nas partes mais críticas da solução, como cadastro, feed e gestão do marketplace.

---

<a id="beneficios"></a>
## 🎯 Benefícios

- ⏱️ **75% de redução no tempo de resposta**: De 48 para até 12 horas na mobilização de ajuda em situações críticas.  
- 📦 **R$ 500 milhões/ano em doações reaproveitadas**: Redução de desperdício e sobreposição de recursos com centralização das campanhas.  
- 🌎 **Maior alcance e capilaridade**: 5 milhões de voluntários engajados e 10 milhões de pessoas diretamente atendidas por ano.  
- 📉 **Economia pública de R$ 350 milhões no primeiro ano**: Redução de custos emergenciais em municípios parceiros.  
- 🛡️ **Ações preventivas e proativas**: Alertas antecipados baseados em dados reais, evitando tragédias e organizando a resposta antes da crise.  
- 💬 **Integração entre todos os agentes**: ONGs, doadores, governos e cidadãos conectados em uma única rede de solidariedade.  

> _“Com Embrace, a resposta a desastres deixa de ser caótica e passa a ser coordenada, humana e baseada em dados.”_

---
<a id="arquitetura"></a>
## 🏗️ Arquitetura
```text

src/main/java/com/fiap/embrace/embrace
├── controller   # Endpoints REST (Anúncios, Campanhas, Doações, ONGs, etc.)
├── dto          # Objetos de transferência de dados (DTOs de entrada e saída)
├── entities     # Entidades JPA mapeadas para o banco de dados Oracle
├── exception    # Manipulação centralizada de exceções (ex: validações)
├── repository   # Interfaces JPA para acesso aos dados
├── service      # Regras de negócio (camada intermediária entre controller e repositório)
└── EmbraceApplication.java  # Classe principal da aplicação Spring Boot

<parent>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-parent</artifactId>
  <version>3.2.5</version>
</parent>
<properties>
  <java.version>17</java.version>
</properties>
<dependencies>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
  </dependency>
  <dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId>
    <version>21.9.0.0</version>
  </dependency>
  <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
  </dependency>
</dependencies>

spring.application.name=geosense
spring.datasource.url=jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl
spring.datasource.username=SEU_RM
spring.datasource.password=SUA_SENHA
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
---
<a id="funcionalidades--testes"></a>
## ⚡ Funcionalidades & Testes

> **Atenção:** esta é a seção mais importante!  
> Teste cada endpoint utilizando no [Postman](https://www.postman.com/) ou pelo link do Deploy [Swagger](https://embrace-java.onrender.com/swagger-ui/index.html#)

📂 Voluntário
▶ POST /cadastrar
Descrição: Cria um novo voluntário no sistema.

Request
POST http://localhost:8080/voluntarios/cadastrar

```json
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456",
  "telefone": "11999999999"
}
```

| Campo      | Tipo   | Obrigatório | Descrição                   |
| ---------- | ------ | ----------- | --------------------------- |
| `nome`     | String | ✅           | Nome completo do voluntário |
| `email`    | String | ✅           | Email válido                |
| `senha`    | String | ✅           | Senha para login            |
| `telefone` | String | ✅           | Número de telefone com DDD  |

Respostas Possíveis
✅ 200 OK: Voluntário criado com sucesso

❌ 400 Bad Request: Dados inválidos

Teste no Swagger
Acesse POST /voluntarios/cadastrar

Clique em "Try it out"

Cole o JSON e clique em "Execute"

Teste no Postman
Método: POST

URL: http://localhost:8080/voluntarios/cadastrar

Aba Body > raw > JSON

Cole o JSON e clique em Send

▶ GET /
Descrição: Lista voluntários com filtros opcionais de nome, paginação e ordenação.

Exemplo de Request
GET http://localhost:8080/voluntarios?nome=joao&page=0&size=5&sort=nome,asc

| Parâmetro | Tipo   | Obrigatório | Descrição                      |
| --------- | ------ | ----------- | ------------------------------ |
| `nome`    | String | ❌           | Parte do nome para filtrar     |
| `page`    | Int    | ❌           | Página (padrão: 0)             |
| `size`    | Int    | ❌           | Tamanho da página (padrão: 10) |
| `sort`    | String | ❌           | Campo e ordem (ex: `nome,asc`) |

Respostas Possíveis
✅ 200 OK: Lista de voluntários paginada

Teste no Swagger
Acesse GET /voluntarios

Clique em "Try it out"

Preencha os filtros desejados e Execute

Teste no Postman
Método: GET

URL: http://localhost:8080/voluntarios?nome=joao&page=0&size=5&sort=nome,asc

▶ GET /{id}
Descrição: Busca um voluntário específico por ID.

Exemplo de Request
GET http://localhost:8080/voluntarios/1

| Parâmetro | Tipo | Obrigatório | Descrição                 |
| --------- | ---- | ----------- | ------------------------- |
| `id`      | Long | ✅           | ID do voluntário a buscar |

Respostas Possíveis
✅ 200 OK: Voluntário encontrado

❌ 404 Not Found: Voluntário inexistente

Teste no Swagger
Acesse GET /voluntarios/{id}, clique em "Try it out", insira o ID e execute

Teste no Postman
Método: GET

URL: http://localhost:8080/voluntarios/1

▶ PUT /{id}
Descrição: Atualiza os dados de um voluntário existente.

Exemplo de Request
PUT http://localhost:8080/voluntarios/1

```json
{
  "nome": "João Atualizado",
  "email": "joao@novo.com",
  "senha": "novaSenha123",
  "telefone": "11988888888"
}
```

| Campo      | Tipo   | Obrigatório | Descrição           |
| ---------- | ------ | ----------- | ------------------- |
| `nome`     | String | ✅           | Nome atualizado     |
| `email`    | String | ✅           | Email atualizado    |
| `senha`    | String | ✅           | Senha atualizada    |
| `telefone` | String | ✅           | Telefone atualizado |

Respostas Possíveis
✅ 200 OK: Atualização bem-sucedida

❌ 400 Bad Request: Dados inválidos

❌ 404 Not Found: Voluntário não encontrado

Teste no Swagger
Acesse PUT /voluntarios/{id}, clique em "Try it out", insira o ID e JSON, e Execute

Teste no Postman
Método: PUT

URL: http://localhost:8080/voluntarios/1

Aba Body > raw > JSON

Cole o JSON e clique em Send

▶ DELETE /{id}
Descrição: Remove um voluntário pelo ID.

Exemplo de Request
DELETE http://localhost:8080/voluntarios/1

| Parâmetro | Tipo | Obrigatório | Descrição                  |
| --------- | ---- | ----------- | -------------------------- |
| `id`      | Long | ✅           | ID do voluntário a deletar |

Respostas Possíveis
✅ 204 No Content: Exclusão bem-sucedida

❌ 404 Not Found: Voluntário não encontrado

Teste no Swagger
Acesse DELETE /voluntarios/{id}, clique em "Try it out", insira o ID e Execute

Teste no Postman
Método: DELETE

URL: http://localhost:8080/voluntarios/1

📂 ONG

▶ POST /cadastrar
Descrição: Cadastra uma nova ONG no sistema.

Request
POST http://localhost:8080/ongs/cadastrar
```json
{
  "nome": "Instituto SOS",
  "email": "contato@sos.com",
  "senha": "SOS123",
  "telefone": "11999998888",
  "cnpj": "83955094000180"
}
```
| Campo      | Tipo   | Obrigatório | Descrição                  |
| ---------- | ------ | ----------- | -------------------------- |
| `nome`     | String | ✅           | Nome da ONG                |
| `email`    | String | ✅           | E-mail de acesso e contato |
| `senha`    | String | ✅           | Senha para login           |
| `telefone` | String | ✅           | Telefone de contato da ONG |
| `cnpj`     | String | ✅           | CNPJ único da ONG          |

Fluxo no Service:

Verifica se CNPJ e e-mail já estão cadastrados.

Valida dados básicos.

Salva a ONG no banco.

Retorna o objeto criado.

Response 200 OK
```json
{
  "id": 1,
  "nome": "Instituto SOS",
  "email": "contato@sos.com",
  "telefone": "11999998888",
  "cnpj": "83955094000180"
}
```

Possíveis Erros:
| Exceção                                   | HTTP | Quando ocorre                             |
| ----------------------------------------- | ---- | ----------------------------------------- |
| `RuntimeException: "CNPJ já cadastrado"`  | 400  | CNPJ duplicado                            |
| `RuntimeException: "Email já cadastrado"` | 400  | E-mail já existe no sistema               |
| `MethodArgumentNotValidException`         | 400  | Campos obrigatórios ausentes ou inválidos |

▶ GET /
Descrição: Lista todas as ONGs com suporte a filtros, ordenação e paginação.
Request
GET http://localhost:8080/ongs?nome=ajuda&page=0&size=5&sort=nome,asc
| Parâmetro | Tipo   | Obrigatório | Descrição                             |
| --------- | ------ | ----------- | ------------------------------------- |
| `nome`    | String | ❌           | Filtro por nome                       |
| `cnpj`    | String | ❌           | Filtro por CNPJ                       |
| `page`    | Int    | ❌           | Número da página (default: 0)         |
| `size`    | Int    | ❌           | Quantidade de registros por página    |
| `sort`    | String | ❌           | Ordenação (ex: nome,asc ou nome,desc) |

Response 200 OK
```json
{
  "content": [
    {
      "id": 1,
      "nome": "Instituto SOS",
      "email": "contato@sos.com",
      "telefone": "11999998888",
      "cnpj": "83955094000180"
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 5,
  "number": 0
}
```

▶ GET /{id}
Descrição: Busca uma ONG específica pelo ID.

Request
GET http://localhost:8080/ongs/{id}

| Parâmetro | Tipo | Descrição               |
| --------- | ---- | ----------------------- |
| `id`      | Long | ID da ONG a ser buscada |
```json
{
  "id": 1,
  "nome": "Instituto SOS",
  "email": "contato@sos.com",
  "telefone": "11999998888",
  "cnpj": "83955094000180"
}
```
Response 404 Not Found
ONG não encontrada para o ID informado.

▶ PUT /{id}
Descrição: Atualiza os dados de uma ONG existente.

Request
PUT http://localhost:8080/ongs/{id}

```json
{
  "nome": "Instituto SOS",
  "email": "instituto@sos.com",
  "senha": "SOS123",
  "telefone": "11999998888",
  "cnpj": "83955094000180"
}
```

| Campo      | Tipo   | Obrigatório | Descrição                    |
| ---------- | ------ | ----------- | ---------------------------- |
| `nome`     | String | ✅           | Nome da ONG                  |
| `email`    | String | ✅           | Novo e-mail (ou o mesmo)     |
| `senha`    | String | ✅           | Senha (requerida)            |
| `telefone` | String | ✅           | Telefone atualizado          |
| `cnpj`     | String | ✅           | CNPJ (não pode ser alterado) |

Response 200 OK:
```json
{
  "id": 1,
  "nome": "Instituto SOS",
  "email": "instituto@sos.com",
  "telefone": "11999998888",
  "cnpj": "83955094000180"
}
```

Possíveis Erros

| Exceção                                   | HTTP | Quando ocorre                    |
| ----------------------------------------- | ---- | -------------------------------- |
| `RuntimeException: "CNPJ já cadastrado"`  | 400  | CNPJ duplicado em outro cadastro |
| `RuntimeException: "Email já cadastrado"` | 400  | E-mail em uso por outra ONG      |
| `RuntimeException: "ONG não encontrada"`  | 404  | ID inexistente                   |

▶ DELETE /{id}
Descrição: Remove uma ONG pelo ID.

Request
DELETE http://localhost:8080/ongs/{id}

| Parâmetro | Tipo | Descrição           |
| --------- | ---- | ------------------- |
| `id`      | Long | ID da ONG a remover |

Response 204 No Content
Sem conteúdo no corpo da resposta. ONG foi removida com sucesso.

Response 404 Not Found
ONG não encontrada para o ID informado.

✅ Testes
🔹 No Swagger
Acesse o Swagger UI da aplicação.

Localize a seção ONGs.

Para cada rota (/cadastrar, GET /, GET /{id}, PUT /{id}, DELETE /{id}), clique em Try it out, preencha os campos e execute.

🔹 No Postman
POST /cadastrar:
Enviar JSON com ONG nova para http://localhost:8080/ongs/cadastrar.

GET /
Testar com e sem filtros, como:
http://localhost:8080/ongs?nome=ajuda&page=0&size=5&sort=nome,asc

GET /{id}
Testar com http://localhost:8080/ongs/1

PUT /{id}
Atualizar os dados da ONG com JSON no body para:
http://localhost:8080/ongs/1

DELETE /{id}
Remover ONG com ID usando:
http://localhost:8080/ongs/1

📂 Coletivos

▶ POST /coletivos

Descrição: Cadastra um novo Coletivo no sistema.

Request
POST http://localhost:8080/coletivos
```json
{
  "nome": "Coletivo Esperança",
  "email": "esperanca@coletivo.org",
  "senha": "senha123",
  "telefone": "11999998888",
  "representante": "João Silva"
}
```

| Campo           | Tipo   | Obrigatório | Descrição                      |
| --------------- | ------ | ----------- | ------------------------------ |
| `nome`          | String | ✅           | Nome do coletivo               |
| `email`         | String | ✅           | E-mail de acesso e contato     |
| `senha`         | String | ✅           | Senha para login               |
| `telefone`      | String | ✅           | Telefone de contato            |
| `representante` | String | ✅           | Nome do representante do grupo |

Fluxo no Service:

Verifica se o e-mail já está cadastrado.

Valida os dados obrigatórios.

Salva o Coletivo no banco.

Retorna o objeto criado.

Response 200 OK

{
  "id": 1,
  "nome": "Coletivo Esperança",
  "email": "esperanca@coletivo.org",
  "telefone": "11999998888",
  "representante": "João Silva"
}

Possíveis Erros

| Exceção                                   | HTTP | Quando ocorre                             |
| ----------------------------------------- | ---- | ----------------------------------------- |
| `RuntimeException: "Email já cadastrado"` | 400  | E-mail já existe no sistema               |
| `MethodArgumentNotValidException`         | 400  | Campos obrigatórios ausentes ou inválidos |

▶ GET /coletivos
Descrição: Lista os Coletivos com suporte a filtros, ordenação e paginação.

Request
GET http://localhost:8080/coletivos?nome=esperança&page=0&size=5&sort=nome,asc

| Parâmetro | Tipo   | Obrigatório | Descrição                             |
| --------- | ------ | ----------- | ------------------------------------- |
| `nome`    | String | ❌           | Filtro parcial por nome do coletivo   |
| `page`    | Int    | ❌           | Número da página (default: 0)         |
| `size`    | Int    | ❌           | Tamanho da página (default: 10)       |
| `sort`    | String | ❌           | Ordenação (ex: nome,asc ou nome,desc) |

Response 200 OK
```json
{
  "content": [
    {
      "id": 1,
      "nome": "Coletivo Esperança",
      "email": "esperanca@coletivo.org",
      "telefone": "11999998888",
      "representante": "João Silva"
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 5,
  "number": 0
}
```

▶ GET /coletivos/{id}
Descrição: Retorna os dados de um Coletivo específico pelo seu ID.

Request
GET http://localhost:8080/coletivos/{id}

| Parâmetro | Tipo | Obrigatório | Descrição                    |
| --------- | ---- | ----------- | ---------------------------- |
| `id`      | Long | ✅           | ID do coletivo a ser buscado |

Response 200 OK
```json
{
  "id": 1,
  "nome": "Coletivo Esperança",
  "email": "esperanca@coletivo.org",
  "telefone": "11999998888",
  "representante": "João Silva"
}
```
Response 404 Not Found

 - Coletivo não encontrado para o ID informado.

▶ PUT /coletivos/{id}
Descrição: Atualiza os dados de um Coletivo existente.

Request
PUT http://localhost:8080/coletivos/{id}
```json
{
  "nome": "Coletivo Renovado",
  "email": "renovado@coletivo.org",
  "senha": "novaSenha123",
  "telefone": "11988887777",
  "representante": "Maria Oliveira"
}
```
| Campo           | Tipo   | Obrigatório | Descrição                         |
| --------------- | ------ | ----------- | --------------------------------- |
| `nome`          | String | ✅           | Nome atualizado do coletivo       |
| `email`         | String | ✅           | Novo e-mail (ou o mesmo anterior) |
| `senha`         | String | ✅           | Nova senha obrigatória            |
| `telefone`      | String | ✅           | Telefone de contato               |
| `representante` | String | ✅           | Novo representante                |

Response 200 OK
```json
{
  "id": 1,
  "nome": "Coletivo Renovado",
  "email": "renovado@coletivo.org",
  "telefone": "11988887777",
  "representante": "Maria Oliveira"
}
```
Possíveis Erros
| Exceção                                       | HTTP | Quando ocorre                    |
| --------------------------------------------- | ---- | -------------------------------- |
| `RuntimeException: "Email já cadastrado"`     | 400  | E-mail em uso por outro coletivo |
| `RuntimeException: "Coletivo não encontrado"` | 404  | ID inexistente                   |

▶ DELETE /coletivos/{id}
Descrição: Remove um Coletivo do sistema pelo ID.

Request
DELETE http://localhost:8080/coletivos/{id}

| Parâmetro | Tipo | Descrição                |
| --------- | ---- | ------------------------ |
| `id`      | Long | ID do coletivo a remover |

Response 204 No Content

Coletivo removido com sucesso.

Sem corpo de resposta.

Response 404 Not Found

Coletivo não encontrado para o ID informado.

✅ Testes
🔹 No Swagger
Acesse o Swagger UI (http://localhost:8080/swagger-ui.html).

Vá até a seção Coletivo.

Clique em Try it out para cada rota.

Envie os dados e confira as respostas.

🔹 No Postman
POST /coletivos

Use método POST para http://localhost:8080/coletivos.

Body > raw > JSON:
```json
{
  "nome": "Coletivo Esperança",
  "email": "esperanca@coletivo.org",
  "senha": "senha123",
  "telefone": "11999998888",
  "representante": "João Silva"
}
```
- GET /coletivos

  -URL com filtro e paginação:
   http://localhost:8080/coletivos?nome=esperança&page=0&size=5&sort=nome,asc

- GET /coletivos/{id}

 - Ex: http://localhost:8080/coletivos/1

- PUT /coletivos/{id}

 - Atualize via PUT para http://localhost:8080/coletivos/1.

  - Body > raw > JSON:
   ```json
{
  "nome": "Coletivo Renovado",
  "email": "renovado@coletivo.org",
  "senha": "novaSenha123",
  "telefone": "11988887777",
  "representante": "Maria Oliveira"
}
```
DELETE /coletivos/{id}

- Exclua usando http://localhost:8080/coletivos/1

📂 CAMPANHAS

▶ POST /campanhas
Descrição: Cria uma nova campanha associada a um evento climático extremo.

Request
POST http://localhost:8080/campanhas
```json
{
  "nome": "Campanha Agasalho Centro",
  "descricao": "Coleta de agasalhos para moradores em situação de rua",
  "cep": "01001-000",
  "logradouro": "Rua Acolhida, 123",
  "bairro": "Centro",
  "cidadeEstado": "São Paulo/SP",
  "tipoEvento": "FRIO",
  "metaDoacoes": 50,
  "dataFim": "2025-08-01T00:00:00",
  "criadorId": 2
}
```
| Campo          | Tipo    | Obrigatório | Descrição                                                                 |
| -------------- | ------- | ----------- | ------------------------------------------------------------------------- |
| `nome`         | String  | ✅           | Nome da campanha                                                          |
| `descricao`    | String  | ✅           | Descrição do objetivo da campanha                                         |
| `cep`          | String  | ✅           | CEP do local onde a campanha está sendo realizada                         |
| `logradouro`   | String  | ✅           | Endereço da campanha                                                      |
| `bairro`       | String  | ✅           | Bairro da campanha                                                        |
| `cidadeEstado` | String  | ✅           | Cidade e estado (ex: São Paulo/SP)                                        |
| `tipoEvento`   | String  | ✅           | Tipo do evento climático (ex: FRIO, ENCHENTE, SECA, etc.)                 |
| `metaDoacoes`  | Integer | ✅           | Meta de doações (precisa ser maior que 0)                                 |
| `dataFim`      | String  | ✅           | Data de encerramento da campanha (formato ISO 8601, não pode ser passada) |
| `criadorId`    | Long    | ✅           | ID da ONG ou usuário que está criando a campanha                          |

Fluxo no Service:

Valida se metaDoacoes > 0

Valida se dataFim é futura

Valida formato do CEP

Verifica se criador (ONG ou admin) existe

Salva e retorna a campanha criada

Response 201 Created
```json
{
  "id": 5,
  "nome": "Campanha Agasalho Centro",
  "descricao": "Coleta de agasalhos para moradores em situação de rua",
  "cep": "01001-000",
  "logradouro": "Rua Acolhida, 123",
  "bairro": "Centro",
  "cidadeEstado": "São Paulo/SP",
  "tipoEvento": "FRIO",
  "metaDoacoes": 50,
  "dataFim": "2025-08-01T00:00:00",
  "criadorId": 2
}
```
Possíveis Erros
| Exceção                                      | HTTP | Quando ocorre                                  |
| -------------------------------------------- | ---- | ---------------------------------------------- |
| `RuntimeException: "Criador não encontrado"` | 404  | ID de criador inválido                         |
| `IllegalArgumentException: "Meta inválida"`  | 400  | Meta de doações menor ou igual a 0             |
| `IllegalArgumentException: "Data inválida"`  | 400  | Data de fim anterior à data atual              |
| `MethodArgumentNotValidException`            | 400  | Campos obrigatórios ausentes ou mal formatados |

▶ GET /campanhas

Descrição: Lista campanhas com filtros opcionais, paginação e ordenação.

Request
GET http://localhost:8080/campanhas?cidadeEstado=São Paulo/SP&tipoEvento=FRIO&page=0&size=10&sort=nome,asc
| Parâmetro      | Tipo   | Obrigatório | Descrição                                        |
| -------------- | ------ | ----------- | ------------------------------------------------ |
| `cidadeEstado` | String | ❌           | Filtro por cidade e estado (ex: São Paulo/SP)    |
| `tipoEvento`   | String | ❌           | Filtro por tipo de evento (FRIO, ENCHENTE, etc.) |
| `page`         | Int    | ❌           | Número da página (default: 0)                    |
| `size`         | Int    | ❌           | Número de registros por página (default: 10)     |
| `sort`         | String | ❌           | Ordenação (ex: nome,asc ou dataFim,desc)         |

Response 200 OK
```json
{
  "content": [
    {
      "id": 5,
      "nome": "Campanha Agasalho Centro",
      "descricao": "Coleta de agasalhos para moradores em situação de rua",
      "cidadeEstado": "São Paulo/SP",
      "tipoEvento": "FRIO",
      "metaDoacoes": 50,
      "dataFim": "2025-08-01T00:00:00"
    }
  ],
  "totalPages": 1,
  "totalElements": 1,
  "last": true,
  "size": 10,
  "number": 0
}
```

▶ GET /campanhas/{id}/doadores
Descrição: Lista todos os doadores vinculados a uma campanha específica.

Request
GET http://localhost:8080/campanhas/1/doadores

| Parâmetro | Tipo | Obrigatório | Descrição                       |
| --------- | ---- | ----------- | ------------------------------- |
| `id`      | Long | ✅           | ID da campanha a ser consultada |

```json
[
  {
    "id": 101,
    "nome": "João da Silva",
    "email": "joao@email.com"
  },
  {
    "id": 102,
    "nome": "Maria Oliveira",
    "email": "maria@email.com"
  }
]
```

Response 404 Not Found
```json
{
  "message": "Campanha não encontrada"
}
```
✅ Testes
🔹 No Swagger

Acesse Swagger UI (/swagger-ui.html)

Localize o grupo "Campanhas"

Teste os endpoints:

POST /campanhas

GET /campanhas

GET /campanhas/{id}/doadores

🔹 No Postman

POST /campanhas

Método: POST

URL: http://localhost:8080/campanhas

Aba Body > raw > JSON

Cole o JSON de exemplo

GET /campanhas

Método: GET

URL: http://localhost:8080/campanhas?cidadeEstado=São Paulo/SP&tipoEvento=FRIO&page=0&size=10

GET /campanhas/{id}/doadores

Método: GET

URL: http://localhost:8080/campanhas/1/doadores

📂 CAMPANHAS

▶ POST /doacoes
Descrição:
Registra uma doação feita por um voluntário para uma campanha ativa. Atualiza o total de doações recebidas e retorna o progresso da meta.

✅ Requisição
POST http://localhost:8080/doacoes
Body (JSON):

```json
{
  "campanhaId": 1,
  "voluntarioId": 2,
  "quantidade": 10
}
```

| Campo          | Tipo | Obrigatório | Descrição                                  |
| -------------- | ---- | ----------- | ------------------------------------------ |
| `campanhaId`   | Long | ✅           | ID da campanha que está recebendo a doação |
| `voluntarioId` | Long | ✅           | ID do voluntário que está doando           |
| `quantidade`   | Int  | ✅           | Quantidade de itens doados (> 0)           |

✅ Resposta: 200 OK
```json
{
  "campanhaId": 1,
  "totalDoado": 80,
  "restante": 20,
  "mensagem": "Faltam 20 item(ns) para atingir a meta."
}
```

| Campo        | Descrição                                                                  |
| ------------ | -------------------------------------------------------------------------- |
| `campanhaId` | ID da campanha                                                             |
| `totalDoado` | Total de itens recebidos até agora                                         |
| `restante`   | Quantidade restante para atingir a meta de doações                         |
| `mensagem`   | Feedback amigável informando quantos itens ainda faltam ou se foi atingida |

❌ Erros comuns
| Código | Motivo                                 |
| ------ | -------------------------------------- |
| 400    | Quantidade <= 0                        |
| 404    | Campanha ou Voluntário não encontrados |
| 400    | Campanha já encerrada (dataFim < hoje) |

Regras de Negócio
Valida se campanha existe e está ativa (data atual <= dataFim).

Verifica se o voluntário existe.

Quantidade deve ser maior que zero.

Soma a doação à campanha.

Retorna total doado, restante e mensagem.

Testes
🔸 Swagger:
Acesse /swagger-ui.html

Vá até POST /doacoes

Clique em "Try it out"

Cole o JSON:
```json
{
  "campanhaId": 1,
  "voluntarioId": 2,
  "quantidade": 10
}
```
Postman:
Método: POST

URL: http://localhost:8080/doacoes

Aba: Body > raw > JSON:
```json
{
  "campanhaId": 1,
  "voluntarioId": 2,
  "quantidade": 10
}
```
📂 ANÚNCIOS 

▶ POST /anuncios
Cria um novo anúncio no marketplace.

✅ Requisição (JSON):
```json
{
  "titulo": "Telhas para reconstrução",
  "descricao": "Preciso de 50 telhas",
  "cep": "12345-678",
  "logradouro": "Rua Exemplo",
  "bairro": "Centro",
  "cidadeEstado": "São Paulo/SP",
  "tipoEvento": "DESLIZAMENTO", 
  "tipoRecurso": "TELHAS",
  "dataFim": "2025-07-31T23:59:00",
  "autorId": 13
}
```
✅ Resposta: 200 OK
Retorna os dados do AnuncioDTO criado.

❌ Erros:
400 Bad Request: Dados inválidos (CEP, dataFim passada, campos obrigatórios ausentes)

404 Not Found: Autor não encontrado

Testes
Swagger
Vá para POST /anuncios

Clique em Try it out

Insira o JSON acima

Clique em Execute

Postman
Método: POST

URL: http://localhost:8080/anuncios

Aba: Body > raw > JSON

Cole o JSON acima

2. Listar Anúncios com Filtros e Paginação
GET /anuncios

🔍 Parâmetros:
tipoEvento: Ex: FRIO, ENCHENTE

cidadeEstado: Parte do nome da cidade ou estado

page: Página (default: 0)

size: Tamanho da página (default: 20)

sort: Campo e direção (ex: dataFim,desc)

✅ Resposta: 200 OK
Retorna uma página de AnuncioDTOs.

🧪 Exemplo:
Swagger
Vá para GET /anuncios

Clique em Try it out

Preencha filtros, por exemplo:
tipoEvento: FRIO  
cidadeEstado: São Paulo  
page: 0  
size: 10  
sort: dataFim,desc  

Postman
Método: GET

URL:http://localhost:8080/anuncios?tipoEvento=FRIO&cidadeEstado=São Paulo&page=0&size=10&sort=dataFim,desc

3. Ofertar Recurso em um Anúncio
POST /anuncios/oferta
Cria uma nova oferta de recurso para um anúncio.

✅ Requisição (JSON):
```json
{
  "anuncioId": 1,
  "voluntarioId": 42,
  "quantidade": 20
}
```
✅ Resposta: 200 OK
```json
{
  "anuncioId": 1,
  "totalOfertado": 80,
  "mensagem": "Total de 80 recurso(s) ofertado(s) até agora."
}
```
❌ Erros:
404 Not Found: Anúncio ou voluntário inexistente

Testes

Swagger
Vá para POST /anuncios/oferta

Clique em Try it out

Insira o JSON acima

Postman
Método: POST

URL: http://localhost:8080/anuncios/oferta

Aba: Body > raw > JSON

Cole o JSON acima

4. Consultar Status das Ofertas
GET /anuncios/{id}/oferta
```json
{
  "anuncioId": 1,
  "totalOfertado": 80
}
```

❌ Erros:
404 Not Found: Anúncio inexistente

Testes
Swagger
Vá para GET /anuncios/{id}/oferta

Clique em Try it out

Informe o ID do anúncio

Postman
Método: GET

URL: http://localhost:8080/anuncios/1/oferta

5. Listar Doadores de um Anúncio
GET /anuncios/{id}/doadores

✅ Resposta (Exemplo): 
```json
[
  {
    "nome": "João Silva",
    "email": "joao@email.com",
    "telefone": "(11) 99999-0000",
    "quantidadeOfertada": 10
  },
  {
    "nome": "Maria Souza",
    "email": "maria@email.com",
    "telefone": "(11) 98888-1111",
    "quantidadeOfertada": 20
  }
]
```

❌ Erros:
404 Not Found: Anúncio não encontrado ou sem doações

Testes
Swagger
Vá para GET /anuncios/{id}/doadores

Clique em Try it out

Informe o ID

Postman
Método: GET

URL: http://localhost:8080/anuncios/1/doadores

<a id="como-executar"></a>

▶️ Como Executar

1. Clone o repositório

git clone https://github.com/RafaellSouzaPinto/GeoSense.git

2. Ajuste suas credenciais
Edite o arquivo:

src/main/resources/application.properties

E configure suas credenciais de banco de dados (ex: PostgreSQL, MySQL, etc).

🌐 Acesse a aplicação
🔗 Localhost: http://localhost:8080/

📘 Swagger da API: https://embrace-java.onrender.com/swagger-ui/index.html
