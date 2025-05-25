package bookstoreconsoleapp;
import java.sql.*;
		import java.util.*;
public class CartSystem {

	public static void main(String[] args) {

		
		        String url = "jdbc:mysql://localhost:3307/book_store";
		        String user = "root";
		        String password = "ISMAIL1509"; // replace this

		        try (Scanner sc = new Scanner(System.in)) {
					List<String> cart = new ArrayList<>();

					try {
					    Class.forName("com.mysql.cj.jdbc.Driver");
					    Connection conn = DriverManager.getConnection(url, user, password);
					    Statement stmt = conn.createStatement();

					    // Display books
					    ResultSet rs = stmt.executeQuery("SELECT * FROM books");
					    System.out.println("Available Books:\n--------------------------");
					    while (rs.next()) {
					        System.out.println("ID: " + rs.getInt("id") +
					                ", Title: " + rs.getString("title") +
					                ", Price: ₹" + rs.getDouble("price"));
					    }

					    // Add to cart loop
					    while (true) {
					        System.out.print("Enter Book ID to add to cart (or 0 to checkout): ");
					        int bookId = sc.nextInt();
					        if (bookId == 0) break;

					        PreparedStatement ps = conn.prepareStatement("SELECT title FROM books WHERE id = ?");
					        ps.setInt(1, bookId);
					        ResultSet brs = ps.executeQuery();
					        if (brs.next()) {
					            String title = brs.getString("title");
					            cart.add(title);
					            System.out.println("✅ Added to cart: " + title);
					        } else {
					            System.out.println("❌ Invalid Book ID");
					        }
					    }

					    // Show cart summary
					    System.out.println("\n🛒 Your Cart:");
					    for (String title : cart) {
					        System.out.println("- " + title);
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

