package br.com.agenda.teste;

import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.*;
import br.com.agenda.*;
import br.com.agenda.DAO.ContatoDAO;
import br.com.agenda.DAOImpl.ContatoDAOImpl;
import br.com.agenda.beans.Contato;
import br.com.agenda.util.ConnectionFactory;
import com.mysql.*;
import br.com.agenda.util.*;

public class TestaConexao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ContatoDAOImpl dao = new ContatoDAOImpl();				//remover
		//dao.remove(7);
		
		//ContatoDAOImpl dao = new ContatoDAOImpl();					// inserir 
		//Contato contato = new Contato();
		
		//Calendar dataNascimento = Calendar.getInstance();
		//dataNascimento.set(1990,3, 22);
		
		//contato.setNome("Henrique Mathias");
		//contato.setEmail("Henrique@gmail.com");
		//contato.setEndereco("Rua Henrique Dias");
		//contato.setDataNascimento(dataNascimento);
		
		//dao.insere(contato);
		
		ContatoDAOImpl dao = new ContatoDAOImpl();
		List<Contato> contatos = dao.buscaTodos();
		
		System.out.println("=============Imprimindo Dados ===============");
		
		for(Contato contato : contatos){
			
			System.out.println("id:"+ contato.getContatoId());
			System.out.println("Nome:"+ contato.getNome());
			System.out.println("Email:"+ contato.getEmail());
			System.out.println("Endereço:"+ contato.getEndereco());
			DateFormat df = new SimpleDateFormat("dd-mm-yyyy");
			System.out.println("Nascimento: "+ df.format(contato.getDataNascimento().getTime()));
			System.out.println("-----------------------------------------------------------------");
		}
		
	}

}
