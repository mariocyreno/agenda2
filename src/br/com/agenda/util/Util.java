package br.com.agenda.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class Util {
	
	public void fechaConexao (Connection con, PreparedStatement pstmt, ResultSet rs) {
		try{
			if(con != null){
				con.close();
			}
			if (pstmt != null){
				pstmt.close();
			}
			if( rs != null){
				rs.close();
			}
		} catch (Exception e){
			
			e.printStackTrace();
			
		}
		
		}
	public  void trataErro (String mensagem, Exception ex){
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
		System.err.println(dateFormat.format(System.currentTimeMillis()) + mensagem + ex.toString());
	}
}



