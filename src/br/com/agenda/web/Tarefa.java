package br.com.agenda.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Tarefa {

	String executa(HttpServletRequest req, HttpServletResponse response);
}
