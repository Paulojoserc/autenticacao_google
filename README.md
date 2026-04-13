# 🔐 Autenticação com Google - Spring Boot OAuth2

Projeto de autenticação utilizando Google OAuth2 com Spring Boot, desenvolvido com foco em boas práticas de arquitetura, segurança e organização de código.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Security
- OAuth2 Client
- Thymeleaf
- HTML5 + CSS3

---

## 🎯 Funcionalidades

✔ Login com conta Google  
✔ Exibição de dados do usuário (nome, e-mail, foto)  
✔ Logout com limpeza de sessão e cookies  
✔ Layout moderno com identidade visual  
✔ Proteção de credenciais com variáveis de ambiente  

---

## 🧠 Diferenciais do projeto

Este projeto foi baseado em um tutorial e evoluído com melhorias importantes:

- 🔹 Separação de responsabilidades (Controller e API)
- 🔹 Uso de `@AuthenticationPrincipal` para acesso aos dados do usuário
- 🔹 Implementação de `.env` para proteger credenciais sensíveis
- 🔹 Configuração completa de logout (invalidate session + cookies)
- 🔹 Uso de Thymeleaf fragments (header/footer reutilizáveis)
- 🔹 CSS externo organizado (padrão profissional)
- 🔹 Estrutura preparada para deploy em VPS

---

## 🖼️ Demonstração

### 🔑 Tela de Login
*(adicione print aqui)*

### 👤 Tela de Perfil
*(adicione print aqui)*

---

## ⚙️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Paulojoserc/autenticacao_google.git
