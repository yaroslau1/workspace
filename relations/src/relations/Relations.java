package relations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Relations {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/autosalon";
		String user = "root";
		String pass = "1234";
		//динамическая загрузка
		try {
			Class.forName("com.mysql.jdbc.Driver");  	//динамическая загрузка
			Connection connection = DriverManager.getConnection(url, user, pass);
			
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Go!");

	}

}
