//Construct JDBC Application to read date from Console and insert
//into DB-table(Emp52):
package jdbcreaddata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DBConnection2 {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		try(sc;){
			try {
				System.out.println("Enter empId");
				String id = sc.nextLine();
				System.out.println("Enter Employee name");
				String name = sc.nextLine();
				System.out.println("Enter the Employee Designation");
				String designation = sc.nextLine();
				System.out.println("Enter the salary");
				int sal = sc.nextInt();
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","System", "admin");
				
				Statement stmt = con.createStatement();
				
				int k = stmt.executeUpdate("insert into Emp values('"+id+"' ,'"+name+"','"+designation+"','"+sal+"')");
				
				if(k>0) {
					System.out.println("Record Inserted successfully");
				}
				con.close();
				
			}
			catch(InputMismatchException ime) {
				System.out.println("Invalid Input....");
			}
			catch(SQLIntegrityConstraintViolationException sicve) {
				System.out.println("Employee details already available");
			}
			catch(SQLException cnfe) {
				cnfe.printStackTrace();
			}
		}
	}
}
