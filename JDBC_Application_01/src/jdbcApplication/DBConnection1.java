package jdbcApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		try {
		//step1: loding Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//step2 Creating Connection
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System","admin");
		
		//step3 preparing Statement
		Statement stmt = con.createStatement();
		
		//step4 Execute query
		ResultSet rs = stmt.executeQuery("select * from Emp");
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + "\t" +
								rs.getString(2) + "\t" + 
								rs.getString(3) + "\t" + 
								rs.getInt(4));
		}//end of loop
		
		//closing connection
		con.close();
		}//end of try
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
