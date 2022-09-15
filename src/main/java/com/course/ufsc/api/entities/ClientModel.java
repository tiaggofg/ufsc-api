package com.course.ufsc.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "TB_CLIENTES")
public class ClientModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Setter(value = AccessLevel.NONE)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@NonNull
	@Column(name = "nome")
	private String name;
	
	@NotNull
	@NonNull
	private String email;
	
	@NotNull
	@NonNull
	@Column(name = "fone")
	private String phone;
	
	@NotNull
	@NonNull
	@Column(name = "senha")
	private String password;

}