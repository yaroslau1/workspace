package com.work.company;

import java.io.IOException;
import java.sql.SQLException;

public class DAOException extends Exception {
	
	public DAOException(SQLException e) {
		initCause(e);
		System.out.println("Something wrong with SQL query");
	}
	
	public DAOException(InstantiationException e) {
		initCause(e);
		System.out.println("Something wromg with Class object");
	}
	
	public DAOException(IllegalAccessException e) {
		initCause(e);
		System.out.println("Something wromg with access to DB");
	}
	
	public DAOException(ClassNotFoundException e) {
		initCause(e);
		System.out.println("Something wromg with ClassPath");
	}
	
	public DAOException(IOException e) {
		initCause(e);
		System.out.println("Something wromg with file opening");
	}

}
