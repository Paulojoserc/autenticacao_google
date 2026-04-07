package br.com.paulocode.autenticacao_google;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class AutenticacaoGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticacaoGoogleApplication.class, args);
	}

}
