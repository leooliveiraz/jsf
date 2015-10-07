package util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utilitarios {
	
	
	public static String  sha256(String texto) throws UnsupportedEncodingException, NoSuchAlgorithmException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(texto.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		String senha = hexString.toString();
		
		return senha;
	}
	
	public static int getQuantidadeDiasMes(int mes, int ano){  
		Calendar datas = new GregorianCalendar();  
		datas.set(Calendar.MONTH, mes-1);//2  
		datas.set(Calendar.YEAR, ano);//2  
		int quantidadeDias = datas.getActualMaximum (Calendar.DAY_OF_MONTH);    
		return quantidadeDias ;  
	}  

	public static Date converteStringData(String dataEntrada)  {
		Date dataSaida = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dataSaida = formatter.parse(dataEntrada);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		return dataSaida;
	}

	public static String converteDataString(Date dataEntrada) {
		String dataSaida = null;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		dataSaida = formatter.format(dataEntrada);
		return dataSaida;
	}
	
	public static int extraiDia(Date dataEntrada) {
		int dia;
		SimpleDateFormat formatter = new SimpleDateFormat("dd");
		dia = Integer.parseInt(formatter.format(dataEntrada));
		return dia;
	}
	
	public static int extraiMes(Date dataEntrada) {
		int mes ;
		SimpleDateFormat formatter = new SimpleDateFormat("MM");
		mes = Integer.parseInt(formatter.format(dataEntrada));
		return mes;
	}

	public static int extraiAno(Date dataEntrada) {
		int ano ;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
		ano = Integer.parseInt(formatter.format(dataEntrada));
		return ano;
	}
	
	public static String extraiCompetencia(Date dataEntrada) {
		String dia = null;
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
		dia = formatter.format(dataEntrada);
		return dia;
	}
	
}
