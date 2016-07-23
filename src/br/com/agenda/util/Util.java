package br.com.agenda.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Util {
	
	public static void trataErro(String msg, Exception ex){
		DateFormat dateF = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.err.println(dateF.format(System.currentTimeMillis()) + msg + ex.toString());
	}
}
