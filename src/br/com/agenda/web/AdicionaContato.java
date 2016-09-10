package br.com.agenda.web;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.Util;

import br.com.agenda.DAOImpl.ContatoDAOImpl;
import br.com.agenda.beans.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContato implements Tarefa{

	@Override
	public String executa (HttpServletRequest req, HttpServletResponse response){
		
		ContatoDAOImpl dao = new ContatoDAOImpl();
		Contato contato = new Contato();
		
		contato.setNome(req.getParameter("nome"));
		contato.setEndereco(req.getParameter("endereco"));
		contato.setEmail(req.getParameter("email"));
		Util util = new Util();
		
		String dtNascimento = req.getParameter("dataNasciemnto");
		Calendar dataNascimento = null;
		
		
		try {
			//.parse passa a String, onde defini ser dtNascimento
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dtNascimento);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			contato.setDataNascimento(dataNascimento);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	dao.insere(contato);
	
	req.setAttribute("contato", contato);
	
	return "/sucesso.jsp";
	}
	
	
	
}
