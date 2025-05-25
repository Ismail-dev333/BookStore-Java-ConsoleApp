package bookstoreconsoleapp;
import java.sql.*;
public class BookList {

	public static void main(String[] args) {
		

		        String url = "jdbc:mysql://localhost:3307/book_store";
		        String user = "root";
		        String password = "ISMAIL1509";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection conn = DriverManager.getConnection(url, user, password);

		            String sql = "SELECT * FROM books";
		            Statement stmt = conn.createStatement();
		            ResultSet rs = stmt.executeQuery(sql);

		            System.out.println("Available Books:\n--------------------------");
		            while (rs.next()) {
		                System.out.println("ID: " + rs.getInt("id"));
		                System.out.println("Title: " + rs.getString("title"));
		                System.out.println("Author: " + rs.getString("author"));
		                System.out.println("Price: ₹" + rs.getDouble("price"));
		                System.out.println("--------------------------");
		            }

		            rs.close();
		            stmt.close();
		            conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}