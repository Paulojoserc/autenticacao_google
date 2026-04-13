package br.com.paulocode.autenticacao_google.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Desabilita o CSRF para permitir logout via link <a> simples
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth
                        // 2. Permite acesso total aos recursos estáticos e páginas iniciais
                        .requestMatchers("/", "/login", "/css/**", "/images/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )

                .oauth2Login(oauth -> oauth
                        .loginPage("/login")
                        .defaultSuccessUrl("/profile", true)
                )

                // 3. Configuração de Logout simplificada
                .logout(logout -> logout
                        .logoutUrl("/logout")            // Define a URL que o botão vai chamar
                        .logoutSuccessUrl("/")           // Para onde vai depois de sair
                        .invalidateHttpSession(true)     // Mata a sessão
                        .clearAuthentication(true)       // Remove a autenticação
                        .deleteCookies("JSESSIONID")     // Limpa o cookie do navegador
                        .permitAll()                     // Garante que todos podem acessar o /logout
                );

        return http.build();
    }
}