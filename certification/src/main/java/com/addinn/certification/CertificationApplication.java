package com.addinn.certification;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CertificationApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(CertificationApplication.class, args);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		  SimpleMailMessage msg = new SimpleMailMessage();
//	        msg.setTo("maroua.chtiwi@gmail.com");
//
//	        msg.setSubject("Testing from Spring Boot");
//	        msg.setText("Hello World \n Spring Boot Email");
//
//	        javaMailSender.send(msg);
		

	}

}
