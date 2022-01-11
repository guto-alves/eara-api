package com.gutotech.eara.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
public class UserDTO {

	private Long id;

	@NonNull
	@NotBlank(message = "Nome deve ser informado")
	private String name;

	@NonNull
	@Column(unique = true)
	private String email;

	@NonNull
	private String password;

}
