package com.addinn.certification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.addinn.certification.entities.Admin;
import com.addinn.certification.repositories.AdminRepository;

@SpringBootApplication()
public class CertificationApplication implements CommandLineRunner {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CertificationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Admin admin = new Admin();
//		admin.setNom("Znaiedi");
//		admin.setPrenom("Aymen");
//		admin.setEmail("aymen@gmail.com");
//		admin.setTel("11111111");
//		admin.setEnabled(true);
//		admin.setPassword(passwordEncoder.encode("admin"));
//		adminRepository.save(admin);

	}

}
