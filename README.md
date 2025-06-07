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
```json

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
