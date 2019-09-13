package com.ptavares.estudoGlores1.estudoGlores1.dto;

import java.io.Serializable;

import com.ptavares.estudoGlores1.estudoGlores1.model.Fabricante;

public class FabricanteDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	private String email;
	
	public FabricanteDTO() {
		
	}

	public FabricanteDTO(Fabricante obj) {
		id = obj.getId();
		nome = obj.getName();
		email = obj.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
