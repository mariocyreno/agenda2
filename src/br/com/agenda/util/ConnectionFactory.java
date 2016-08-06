package br.com.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String URL = "jdbc:mysql://localhost:3306/agenda";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			//Util.trataErro(ConstantesSistema.MSG_ERRO_CONNECTION_001,  e);
			e.printStackTrace();
		}
		return con;
	}
}
