package products;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Product {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		try {
			System.out.println("step1: loading driver");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("step2: creating connection");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","admin");
		
		Statement stmt = con.createStatement();
		
		System.out.println("step3: execute query");
		ResultSet rs = stmt.executeQuery("select * from product");
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +rs.getInt(3) + "\t" + rs.getInt(4));
		}
		
		con.close();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
