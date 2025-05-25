package bookstoreconsoleapp;
import java.sql.*;
import java.util.Scanner;
public class UserRegister {
		    public static void main(String[] args) {
		        String url = "jdbc:mysql://localhost:3307/book_store";
		        String user = "root";
		        String password = "ISMAIL1509";

		        try (Scanner sc = new Scanner(System.in)) {
					System.out.print("Enter name: ");
					String name = sc.nextLine();
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					System.out.print("Enter password: ");
					String pwd = sc.nextLine();

					try {
					    Connection conn = DriverManager.getConnection(url, user, password);
					    String sql = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
					    PreparedStatement stmt = conn.prepareStatement(sql);
					    stmt.setString(1, name);
					    stmt.setString(2, email);
					    stmt.setString(3, pwd);

					    int rows = stmt.executeUpdate();
					    if (rows > 0) {
					        System.out.println("User registered successfully!");
					    }

					    stmt.close();
					    conn.close();
					} catch (SQLException e) {
					    e.printStackTrace();
					}
				}
		    }

	}
