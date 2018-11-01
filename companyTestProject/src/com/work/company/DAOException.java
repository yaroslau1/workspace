package com.work.company;

import java.io.IOException;
import java.sql.SQLException;

public class DAOException extends Exception {
	
	public DAOException(String description, SQLException e) {
		initCause(e);
	}
	
	public DAOException(String description, InstantiationException e) {
		initCause(e);
	}
	
	public DAOException(String description, IllegalAccessException e) {
		initCause(e);
	}
	
	public DAOException(String description, ClassNotFoundException e) {
		initCause(e);
	}
	
	public DAOException(String description, IOException e) {
		initCause(e);
	}

}
