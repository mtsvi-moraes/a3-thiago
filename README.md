# Sistema anti fraude Bradesco

Sistema para detecção e prevenção de fraudes bancárias, desenvolvido como projeto universitário para o Bradesco. O projeto é composto por uma API principal em Java (Spring Boot) e um backend auxiliar em Python que utiliza IA para análise de e-mails suspeitos.

## Estrutura do Projeto

- **Java (Spring Boot)**: API principal para gerenciamento e exposição dos endpoints REST.
- **Python Backend**: Serviço Flask que utiliza o modelo Gemini AI para detectar spam em e-mails.
- **MySQL**: Banco de dados relacional para persistência dos dados.
- **Docker**: Facilita a execução dos serviços em containers.

## Como Executar

### 1. Pré-requisitos

- Docker e Docker Compose instalados
- Java 21+ (caso queira rodar sem Docker)
- Python 3.12+ (caso queira rodar o backend Python localmente)

### 2. Configuração de Variáveis de Ambiente

- Edite o arquivo `.env` na raiz para configurar o banco de dados.
- O backend Python utiliza `src/python-backend/.env` para a chave da API Gemini.

### 3. Subindo com Docker

```sh
docker compose up
```

- A aplicação Java estará disponível em `http://localhost:8080`
- O backend Python (se rodar manualmente) estará em `http://localhost:5000`
- O banco de dados MySQL estará em `localhost:3306`

### 4. Rodando o Backend Python manualmente

Entre na pasta `src/python-backend` e execute:

```sh
pip install -r requirements.txt
python app.py
```

### 5. Testando a API

- Acesse `http://localhost:8080/` para verificar se a API Java está rodando.
- Acesse `http://localhost:5000/` para testar a análise de e-mails via IA.

## Funcionalidades

- **/ (Java)**: Endpoint de health check.
- **/api/hello** e **/api/goodbye** (Python): Endpoints de teste.
- **/** (Python): Analisa o conteúdo de um e-mail e retorna se é spam, com confiança e timestamp.

## Tecnologias Utilizadas

- Java 21, Spring Boot
- Python 3.12, Flask, google-genai
- MySQL
- Docker, Docker Compose

## Observações

- O backend Python depende de uma chave válida da API Gemini.
- O sistema pode ser expandido para integrar a análise de IA diretamente na API Java.

---

