package br.com.agenda.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.DAOImpl.ContatoDAOImpl;
import br.com.agenda.beans.Contato;

@WebServlet("/busca")
public class BuscaContato implements Tarefa {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse response){
			
		ContatoDAOImpl dao = new ContatoDAOImpl();
		List<Contato> contatos = new ArrayList<>();
		Contato contato = null;
		
		String idContato = req.getParameter("id");
		
		if(idContato != "null" && idContato != ""){
			contato = dao.busca(Integer.valueOf(idContato));
			contatos.add(contato);
		}else{
			contatos = dao.buscaTodos();
		}
		
		req.setAttribute("contatos", contato);
		return "/buscaContato.jsp";
	}
}
