package br.com.web.conexao.util;

public class DAOException extends Exception{
	
	public DAOException() {
		
		
	}
	
	public DAOException(String message) {
		super(message);
	}
	
	public DAOException(Throwable cause) {
		super(cause);		
	}
	
	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public DAOException(String message, Throwable cause, boolean enableSuppresion, boolean writeStackTrace) {
		
		super(message, cause, enableSuppresion, writeStackTrace);
	}
	
	

}
