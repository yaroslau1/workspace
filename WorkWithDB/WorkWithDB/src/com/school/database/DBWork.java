package com.school.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWork {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/world";
		String user = "root";
		String pass = "1234";
		//динамическая загрузка
		try {
			Class.forName("com.mysql.jdbc.Driver");  	//динамическая загрузка
			Connection connection = DriverManager.getConnection(url, user, pass);// соединение открыли
			Statement statement = connection.createStatement(); //для работы создали
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM city");
			while(resultSet.next()){
				String id = resultSet.getString("ID");
				String name = resultSet.getString("Name");
				String population = resultSet.getString("Population");
				System.out.println(id + " "+ name + " " + population);
			}
			
			connection.close(); // соединение закрыли, считается правильно открывать соединение, делать запрос и сразу закрывать соединение
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Congratulation!!!!");
		
		
	}

}
