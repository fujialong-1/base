package jdbc;


import java.sql.*;

/**
 * @Author: Jialong Fu
 * @Date: 2022/5/22 21:09
 */
public class JDBCTest {

    public static void main(String[] args) throws ClassNotFoundException {
        testJDBC();
    }

    public static void testJDBC() throws ClassNotFoundException {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "2016";
        // Register the Driver class
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Create connection
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            // Create statement
            try (Statement stmt = conn.createStatement()) {
                // Execute queries
                try (ResultSet rs = stmt.executeQuery("select id, grade, name, gender from students where gender=1")) {
                    while (rs.next()) {
                        long id = rs.getLong(1);
                        int grade = rs.getInt(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println("id = " + id + ", grade = " + grade + ", name = " + name + ", gender = " + gender);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
