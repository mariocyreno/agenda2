package br.com.agenda.util;

public class SQL {

	public static final String INSERE = "INSERT INTO CONTATO "
			+ "(NOME, EMAIL, ENDERECO, DATA_NASCIMENTO) VALUES(?, ?, ?, ?)";
	
	public static final String BUSCA_TODOS = "SELECT * FROM CONTATO";
}
