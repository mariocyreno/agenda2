package br.com.agenda.DAO;

import java.util.List;

import br.com.agenda.beans.Contato;

public interface ContatoDAO {
	public void insere(Contato contato);
	public void remove(Integer idContato);
	public Contato busca(Integer idContato);
	public List<Contato> buscaTodos();
}
