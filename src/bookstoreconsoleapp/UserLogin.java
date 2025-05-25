package bookstoreconsoleapp;
import java.sql.*;
		import java.util.Scanner;
public class UserLogin {

	public static void main(String[] args) {
		
		        String url = "jdbc:mysql://localhost:3307/book_store"; // Use your correct port if needed
		        String user = "root";
		        String password = "ISMAIL1509";

		        try (Scanner sc = new Scanner(System.in)) {
					System.out.print("Enter email: ");
					String email = sc.nextLine();
					System.out.print("Enter password: ");
					String pwd = sc.nextLine();

					try {
					    Class.forName("com.mysql.cj.jdbc.Driver");
					    Connection conn = DriverManager.getConnection(url, user, password);
					    String sql = "SELECT * FROM users WHERE email = ? AND password = ?";
					    PreparedStatement stmt = conn.prepareStatement(sql);
					    stmt.setString(1, email);
					    stmt.setString(2, pwd);

					    ResultSet rs = stmt.executeQuery();
					    if (rs.next()) {
					        System.out.println("Login successful! Welcome, " + rs.getString("name"));
					    } else {
					        System.out.println("Invalid email or password.");
					    }

					    rs.close();
					    stmt.close();
					    conn.close();
					} catch (Exception e) {
					    e.printStackTrace();
					}
				}

	}

}
