package com.addinn.certification.util;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class PasswordGeneratorUtil {

	public String generate() {
		Random random = new Random();
		String pwd = String.format("%04d",
				random.nextInt(100000000));
		return pwd;
	}
}
