package product_assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Product {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try(sc;){
			try {
				System.out.println("Enter productId");
				int id = sc.nextInt();
				System.out.println("Enter Product name");
				String name = sc.next();
				System.out.println("Enter Product pricre");
				int pprice = sc.nextInt();
				System.out.println("Enter Product Qty");
				int qty = sc.nextInt();
				
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "System", "admin");
				
				Statement stmt = con.createStatement();
				
				int k = stmt.executeUpdate("insert into product values('"+id+"','"+name+"','"+pprice+"','"+qty+"')");
				
				if(k>0) {
					System.out.println("Record inserted successfully....");
				}
				con.close();
			}
				catch(InputMismatchException ime) {
					System.out.println("Invalid input....");
				}
				catch(SQLIntegrityConstraintViolationException sicve) {
					System.out.println("Employee details already available");
			}
			catch(SQLException cnf) {
				cnf.printStackTrace();
			}
		}

	}
}