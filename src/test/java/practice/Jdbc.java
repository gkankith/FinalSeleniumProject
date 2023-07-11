package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc {

	public static void main(String[] args) throws Throwable {
		
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/weekend","scott","tiger");
		Statement stat = conn.createStatement();
		String query = "select * from emp";
		ResultSet result = stat.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(0));
		}
		
		conn.close();
	}
}
