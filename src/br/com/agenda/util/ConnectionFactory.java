package br.com.agenda.util;

import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.*;


public class ConnectionFactory {
	
	public static final String URL = "jdbc:mysql://localhost:3306/agenda";
	public static final String USUARIO = "root";
	public static final String SENHA ="";
	
	
	
	public Connection getConnection(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();// Isso so é necessaria em alguns bancos como, TOMCAT, JETTY,WIDFLY
			
			con = DriverManager.getConnection(URL,USUARIO,SENHA);
			
			System.out.println("Conexao estabelecida com sucesso! ");
			
		}catch (Exception e){
			
			System.err.println("Conexao nao estabelecida! ");
			
		}
				
		return con;
	}

}
