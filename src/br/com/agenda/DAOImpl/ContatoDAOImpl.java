package br.com.agenda.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.*;
import br.com.agenda.*;
import br.com.agenda.DAO.ContatoDAO;
import br.com.agenda.beans.Contato;
import br.com.agenda.util.ConnectionFactory;
import br.com.agenda.util.SQL;
import br.com.agenda.util.Util;

public class ContatoDAOImpl implements ContatoDAO{
	
	
	private  Connection con;
	private Util util = new Util();
	
	public ContatoDAOImpl(){
		// TODO Auto-generated constructor stub
		
		ConnectionFactory conf = new ConnectionFactory();
		this.con = conf.getConnection();
		
	}
	
	@Override
	public void insere(Contato contato) {
		// TODO Auto-generated method stub
		
		ConnectionFactory conf = new ConnectionFactory();				//PRIMEIRO PASSO CRIAR UMA CONEXAO COM O BANCO (CON)
		Connection con = conf.getConnection();
		
		PreparedStatement pstmt = null;
		//String sql = "INSERT INTO CONTATO(NOME,EMAIL,ENDERECO,DATA_NASCIMENTO) VALUES (?,?,?,?)";
		
		try{
			
			pstmt = con.prepareStatement(SQL.INSERE_CONTATO);
			
			pstmt.setString(1, contato.getNome());
			pstmt.setString(2, contato.getEmail());
			pstmt.setString(3, contato.getEndereco());
			pstmt.setDate(4,  new Date(contato.getDataNascimento().getTimeInMillis()));
			
			pstmt.execute();
			pstmt.close();
			
		}catch (Exception e){
			System.err.println("Erro no dao.insere");
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void remove(Integer contatoId) {
		// TODO Auto-generated method stub
		
		ConnectionFactory conf = new ConnectionFactory();              //PRIMEIRO PASSO CRIAR UMA CONEXAO (CON)
		this.con = conf.getConnection();
		
		//String sql = "DELETE FROM CONTATO WHERE CONTATO_ID = ?";       // SEGUNDO PASSO P SQL (INSERT,DELETE)
		
		PreparedStatement pstmt = null;					// TERCEIRO PASSO CRIAR UM PreparedStatement PARA SE CONETAR COM O BANCO
		
		try{
			
			pstmt = con.prepareStatement(SQL.REMOVE_CONTATO);			// PREPARA O PSTMT( PASSANDO O CON E O SQL
			pstmt.setInt(1, contatoId);					// SUBSTITURI AS "?' PELOS OS "VALORES"
			
			pstmt.execute();							
			
			
		} catch (Exception e){
			
			e.printStackTrace();
			
		} finally{									// DEPOIS EXAECUTAR E FECHAR
			
			util.fechaConexao(con, pstmt, null);
		}
		
	}

	@Override
	public Contato busca(Integer contatoId) {
		// TODO Auto-generated method stub
		Contato contato = new Contato();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try{
			pstmt = con.prepareStatement(SQL.CONSULTA_CONTATOS_POR_ID);
			pstmt.setInt(1, contatoId);
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Contato c1 = new Contato();
				
				c1.setContatoId(rs.getInt("contato_id"));
				c1.setNome(rs.getString("nome"));
				c1.setEmail(rs.getString("email"));
				c1.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				c1.setDataNascimento(data);
				
				contato = c1;
				
				}
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			util.fechaConexao(con, pstmt, rs);
		}
		
		
		return contato;
		
		
		
	}

	@Override
	public List<Contato> buscaTodos() {
		// TODO Auto-generated method stub
		
		List<Contato> lista = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			pstmt = con.prepareStatement(SQL.CONSULTA_TODOS_CONTATOS);
			rs = pstmt.executeQuery();
			
			while (rs.next()){
				
				Contato c = new Contato();
				
				c.setContatoId(rs.getInt("contato_id"));
				c.setNome(rs.getString("nome"));
				c.setEmail(rs.getString("email"));
				c.setEndereco(rs.getString("endereco"));
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("data_nascimento"));
				c.setDataNascimento(data);
				
				lista.add(c);
			}
			
		} catch(Exception e){
			
			e.printStackTrace();
			
		}finally {
			util.fechaConexao(con, pstmt, rs);
		}
		
		
		return lista;
	}

}
