package br.com.agenda.DAO;

import java.util.*;
import br.com.agenda.beans.Contato;

public interface ContatoDAO {
	
	public void insere (Contato contato);
	public void  remove (Integer contatoId);
	public Contato busca (Integer contatoId);
	public List<Contato> buscaTodos();

}
