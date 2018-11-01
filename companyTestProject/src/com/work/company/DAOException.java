package com.work.company;

import java.io.IOException;
import java.sql.SQLException;

public class DAOException extends Exception {
	
	public DAOException(SQLException e) {
		initCause(e);
	}
	
	public DAOException(InstantiationException e) {
		initCause(e);
	}
	
	public DAOException(IllegalAccessException e) {
		initCause(e);
	}
	
	public DAOException(ClassNotFoundException e) {
		initCause(e);
	}
	
	public DAOException(IOException e) {
		initCause(e);
	}

}
