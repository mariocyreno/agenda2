package br.com.agenda.teste;

import java.util.Calendar;
import java.util.List;

import br.com.agenda.DAOImpl.ContatoDAOImpl;
import br.com.agenda.beans.Contato;

public class TestaDAO {

	public static void main(String[] args) {
	/*	Contato cont = new Contato();
		ContatoDAOImpl dao = new ContatoDAOImpl();
		cont.setNome("Samuel Rodrigues");
		cont.setEmail("samuel@gmail.com");
		cont.setEndereco("r. 28");
		
		Calendar cal = Calendar.getInstance();
		cal.set(1991, 11, 28);
		
		cont.setDataNascimento(cal);
		dao.insere(cont);*/
		
		ContatoDAOImpl dao = new ContatoDAOImpl();
		List<Contato>  lista = dao.buscaTodos();
		
		System.out.println("Contatos : ");
		for (Contato contato : lista) {
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("------------");
		}
		
	}

}
