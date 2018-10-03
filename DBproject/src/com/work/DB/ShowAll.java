package com.work.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowAll{
	private static String url = "jdbc:mysql://localhost/cardian";
	private static String user = "root";
	private static String pass = "1234";
	
	
		
	public static void showFromDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");  	//динамическая загрузка
			Connection connection = DriverManager.getConnection(url, user, pass);// соединение открыли
			Statement statement = connection.createStatement(); //для работы создали
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM cardian.people");
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String name = resultSet.getString("name");
				String age = resultSet.getString("age");
				System.out.println(id + " "+ name + " " + age);
			}
			
			connection.close(); // соединение закрыли, считается правильно открывать соединение, делать запрос и сразу закрывать соединение
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
	}
	
	public static void addValues(String name, int age) {
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			String sql = "INSERT INTO cardian.people (name, age) VALUES (?, ?)";// защищенная вставка, защита от запросов -инъекций
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			
			preparedStatement.execute();
			
			connection.close();
		} catch (SQLException e) {
			System.out.println(e);
		}// соединение открыли
		
	}

}
