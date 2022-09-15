package com.course.ufsc.api.dtos;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;


@Getter
@Setter
public class ClientDto {

	@NotBlank
	@NonNull
	private String name;
	
	@NotBlank
	@NonNull
	private String email;
	
	@NotBlank
	@NonNull
	private String phone;
	
	@NotBlank
	@NonNull
	private String password;
	
}
