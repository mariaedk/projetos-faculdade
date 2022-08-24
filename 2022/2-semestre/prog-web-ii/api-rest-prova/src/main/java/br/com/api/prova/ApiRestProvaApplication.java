package br.com.api.prova;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication

public class ApiRestProvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestProvaApplication.class, args);
//		System.out.println(getPasswordEncoder("senha123"));
	}

//	public static String getPasswordEncoder(String senha)
//	{
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder.encode(senha);
//	}
	
}
