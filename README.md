# Orama: Sua Visão Completa das Finanças

<div align="center" style="margin: 30px 0;">
<img src="https://github.com/user-attachments/assets/72defdb8-7d8e-4081-a46e-fd9886d23d98" width="25%" alt="Orama - Sua Visão Completa das Finanças">
</div>

Orama é um aplicativo web de gerenciamento financeiro pessoal, com o objetivo de oferecer uma visão clara e abrangente das suas finanças. A ideia é criar uma ferramenta intuitiva e organizada, que permita aos usuários registrar suas transações, visualizar seu saldo e planejar seu futuro financeiro com facilidade.

## Funcionalidades Planejadas

*   **Registro de Transações:** Adicionar receitas e despesas de forma simples e categorizada.
*   **Visualização de Saldo:** Acompanhar o saldo mensal de maneira clara e intuitiva.
*   **Planejamento Financeiro:** Oferecer uma visão geral das finanças para auxiliar na tomada de decisões.

## Como executar com Docker

Siga os passos abaixo para clonar e executar o projeto localmente em sua máquina usando Docker.

### Pré-requisitos

Garanta que você tenhas as seguintes ferramentas instaladas:

- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/) (com Docker Compose)

---

### Clone o repositorio

```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

---

### Configure o Ambiente

A aplicação utiliza um arquivo ```.env``` para gerenciar as credenciais do banco de dados.<br>
Copie o arquivo de exemplo:

**Windows (Command Prompt):**
```bash
copy .env.example .env
```

---

### 🐳 Execute a aplicação
Na raiz do projeto, rode:<br>
```bash
docker-compose up --build
```
Esse comando irá:<br>
* Construir a imagem da aplicação

* Baixar e configurar a imagem do PostgreSQL

* Iniciar os dois contêineres

---


## Tecnologias (Em Definição)

*   **Back-end:** Java com Spring Boot.
*   **Banco de Dados:** PostgreSQL.
*   **Front-end:** A ser definido.
*   **Docker**


## Modelagem de Dados
![Captura de tela 2025-06-23 203156](https://github.com/user-attachments/assets/d225e4d8-a986-4db6-ac8c-47603629b07a)

## Roadmap

O projeto está em fase inicial de planejamento. O próximo passo é definir as tecnologias e começar a implementação das funcionalidades básicas.

## Como Contribuir

Embora o projeto ainda esteja em fase inicial, sugestões e ideias são sempre bem-vindas! Se você tiver alguma sugestão ou quiser acompanhar o desenvolvimento, sinta-se à vontade para abrir uma issue.
