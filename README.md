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
![Tela de Login](https://github.com/Paulojoserc/autenticacao_google/blob/main/docs/login.jpg)

### 👤 Tela de Perfil
![Tela de Perfil](https://github.com/Paulojoserc/autenticacao_google/blob/main/docs/profile.jpeg)

---

## ⚙️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Paulojoserc/autenticacao_google.git
```
### 2. Criar arquivo .env

Na raiz do projeto, crie um arquivo chamado .env e adicione:
```env
GOOGLE_CLIENT_ID=seu_client_id
GOOGLE_CLIENT_SECRET=seu_client_secret
```
### 3. Configurar o Google Cloud
- Acesse o Google Cloud Console
- Crie credenciais OAuth2
- Configure o redirect URI:
```bash
http://localhost:8080/login/oauth2/code/google
```
### 4. Configurar o application.properties
Certifique-se de que o projeto está lendo o .env:
```properties
spring.application.name=autenticacao_google
spring.config.import=optional:file:.env[.properties]

spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
```
### 5. Executar o projeto
Via Maven:
```Bash
./mvnw spring-boot:run
```
Ou execute diretamente pela IDE (IntelliJ/Eclipse).
### 6. Acessar no navegador
Abra:
```Bash
http://localhost:8080
```
### 🔐 Segurança
As credenciais sensíveis não são armazenadas no repositório.
O projeto utiliza variáveis de ambiente (.env) para proteger os dados do OAuth2.

### 🚀 Próximos passos
- [ ] Deploy em VPS
- [ ] Configuração de domínio
- [ ] HTTPS com SSL
- [ ] Integração com banco de dados
- [ ] Cadastro de usuários

### 🙏 Créditos
Este projeto foi desenvolvido com base no excelente conteúdo do professor Matheus Battisti.

📺 Vídeo utilizado:
https://www.youtube.com/watch?v=o-3LlhkjQzs

Foram aplicadas melhorias e adaptações para tornar o projeto mais próximo de um ambiente profissional.

### 👨‍💻 Autor
Paulo Costa
https://github.com/Paulojoserc

### ⭐ Se este projeto te ajudou, deixe uma estrela!
