package com.addinn.certification.model;

import lombok.Data;

@Data
public class PasswordDto {
	private Integer id;
	private String oldPassword;
	private String newPassword;
}
