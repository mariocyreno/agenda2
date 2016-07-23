package br.com.agenda.teste;

import br.com.agenda.util.ConnectionFactory;

public class TestaConnection {
	
	public static void main(String[] args) {
		ConnectionFactory factory = new ConnectionFactory();
		factory.getConnection();
		
	}
}
