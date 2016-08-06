package br.com.agenda.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.agenda.DAO.ContatoDAO;
import br.com.agenda.beans.Contato;
import br.com.agenda.util.ConnectionFactory;
import br.com.agenda.util.SQL;

public class ContatoDAOImpl implements ContatoDAO {

	private Connection con;
	
	public ContatoDAOImpl() {
		super();
		this.con = new ConnectionFactory().getConnection();
	}

	@Override
	public void insere(Contato contato) {
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.INSERE);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			stmt.execute();
			stmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remove(Integer idContato) {
		// TODO Auto-generated method stub

	}

	@Override
	public Contato busca(Integer idContato) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> buscaTodos() {
		List<Contato>  lista = new ArrayList<>();
		
		try {
			PreparedStatement stmt = con.prepareStatement(SQL.BUSCA_TODOS);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato cont = new Contato();
				cont.setId(rs.getInt("contato_id"));
				cont.setNome(rs.getString("nome"));
				cont.setEmail(rs.getString("email"));
				cont.setEndereco(rs.getString("endereco"));
				
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("data_nascimento"));
				
				cont.setDataNascimento(cal);
				
				lista.add(cont);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}

}
