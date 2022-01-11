package com.gutotech.eara.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PasswordForm {
	@NotBlank(message = "Campo Senha é obrigatório")
	private String password;

	@Size(min = 4, message = "Nova Senha deve conter 4 caracteres no mínino")
	private String newPassword;

	@NotBlank(message = "Campo Confirmação da Nova Senha é obrigatório")
	private String confirmPassword;
}
