# 🚀 Google OAuth2 Authentication with Spring Boot 4

Este projeto é uma implementação de autenticação social utilizando **Spring Security** e **Google Cloud Console**. A aplicação foi desenhada para um ambiente de deploy moderno e seguro, utilizando containers Docker, Registry privado (Harbor) e automação via Gitea Actions em uma rede privada.

---

## 🛠️ Tecnologias e Ferramentas

* **Java 17** & **Spring Boot 4**
* **Spring Security** (OAuth2 Client)
* **Thymeleaf** (Front-end responsivo)
* **Docker** (Containerização)
* **Gitea Actions** (CI/CD Pipeline)
* **Harbor** (Private Image Registry)
* **Tailscale** (Túnel VPN para deploy seguro em VPS)

---

## 📋 Pré-requisitos

Para rodar este projeto, você precisará de:
1.  **Google Cloud Console**: Criar um projeto e configurar a "Tela de permissão OAuth".
2.  **Credenciais**: Obter o `Client ID` e o `Client Secret`.
3.  **URI de Redirecionamento**: Configurar no console do Google:
    * `http://localhost:8080/login/oauth2/code/google`

---

## ⚙️ Configuração Local

1.  **Clone o repositório:**
    ```bash
    git clone http://seu-gitea-local:3000/paulo-code/autenticacao-google.git
    cd autenticacao-google
    ```

2.  **Configuração de variáveis:**
    Não suba suas credenciais para o Git. Configure-as no seu `application.properties` ou como variáveis de ambiente:
    ```properties
    spring.security.oauth2.client.registration.google.client-id=${GOOGLE_CLIENT_ID}
    spring.security.oauth2.client.registration.google.client-secret=${GOOGLE_CLIENT_SECRET}
    ```

3.  **Executar a aplicação:**
    ```bash
    ./mvnw spring-boot:run
    ```

---

## 🚀 CI/CD & Deploy (Fluxo de Infraestrutura)

Este projeto foi estruturado para não expor portas do ambiente local para a internet:

1.  **Build:** O **Gitea Runner** detecta o *push* na branch `main` e inicia o build da imagem Docker.
2.  **Registry:** A imagem é enviada para o **Harbor** (local).
3.  **Túnel:** O **Tailscale** conecta o servidor local ao VPS através de uma rede privada.
4.  **Deploy:** O Workflow via SSH instrui o VPS a fazer o `docker pull` da imagem do Harbor através do IP da VPN e subir o container com **Docker Compose**.

---

## 📂 Estrutura de Endpoints

* `GET /` - Home pública.
* `GET /login` - Tela de login customizada com botão Google.
* `GET /profile` - Exibe informações do perfil (Nome, E-mail e Foto) recuperadas do Google.
* `GET /user` - Retorna os detalhes do objeto `Principal` (JSON).

---

## 🛡️ Segurança

* Uso de **Stateful Sessions** com Cookies protegidos.
* Configuração de `Content-Security-Policy`.
* Acesso restrito a rotas sensíveis via `SecurityFilterChain`.

---

Desenvolvido por [Paulo Code](https://github.com/seu-perfil) 👨‍💻
