package br.com.agenda.beans;

import java.util.*;

public class Contato {
	
	private Integer contatoId;
	private String nome;
	private String email;
	private String endereco;
	private Calendar dataNascimento;
	
	
	
	public Integer getContatoId() {
		return contatoId;
	}
	public void setContatoId(Integer contatoId) {
		this.contatoId = contatoId;
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
	
	

}
