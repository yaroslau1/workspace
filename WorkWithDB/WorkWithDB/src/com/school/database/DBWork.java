package com.school.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBWork {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/autosalon";
		String user = "root";
		String pass = "1234";
		//динамическая загрузка
		/*try {
			Class.forName("com.mysql.jdbc.Driver");  	//динамическая загрузка
			Connection connection = DriverManager.getConnection(url, user, pass);// соединение открыли
			Statement statement = connection.createStatement(); //для работы создали
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM autos");
			while(resultSet.next()){
				String marka = resultSet.getString("marka");
				String speed = resultSet.getString("speed");
				String price = resultSet.getString("price");
				System.out.println(marka + " "+ speed + " " + price);
			}
			
			connection.close(); // соединение закрыли, считается правильно открывать соединение, делать запрос и сразу закрывать соединение
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("Congratulation!!!!");
		
		try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			String marka = "Audi";
			int speed = 215;
			int price = 26000;
			String sql = "INSERT INTO autos (marka, speed, price) VALUES (?, ?, ?)";// защищенная вставка, защита от запросов -инъекций
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, marka);
			preparedStatement.setInt(2, speed);
			preparedStatement.setInt(3, price);
			
			preparedStatement.execute();
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// соединение открыли

	}

}
