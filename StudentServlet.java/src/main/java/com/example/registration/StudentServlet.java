package com.example.registration;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/servlet_jdbc";
        String user = "root";
        String password = "root123";

        String roll = request.getParameter("roll");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to database
            Connection con = DriverManager.getConnection(url, user, password);

            // Create student table if it doesn't exist
            String createTableSQL = "CREATE TABLE IF NOT EXISTS student ("
                    + "roll VARCHAR(10) PRIMARY KEY,"
                    + "name VARCHAR(100),"
                    + "dept VARCHAR(50))";

            Statement tableStmt = con.createStatement();
            tableStmt.executeUpdate(createTableSQL);

            // Insert data
            String insertQuery = "INSERT INTO student (roll, name, dept) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, roll);
            ps.setString(2, name);
            ps.setString(3, dept);
            ps.executeUpdate();

            out.println("<h3>Student Added Successfully!</h3>");

         // Display all students
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            out.println("<h2 style='color:#333; font-family: Arial, sans-serif;'>All Registered Students:</h2>");

            // Table with CSS styling for better appearance
            out.println("<table style='border-collapse: collapse; width: 100%; font-family: Arial, sans-serif;'>");
            out.println("<thead>");
            out.println("<tr style='background-color: #007BFF; color: white;'>");
            out.println("<th style='padding: 10px; border: 1px solid #ddd;'>Roll No</th>");
            out.println("<th style='padding: 10px; border: 1px solid #ddd;'>Name</th>");
            out.println("<th style='padding: 10px; border: 1px solid #ddd;'>Department</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");

            while (rs.next()) {
                out.println("<tr style='border-bottom: 1px solid #ddd;'>");
                out.println("<td style='padding: 10px;'>" + rs.getString("roll") + "</td>");
                out.println("<td style='padding: 10px;'>" + rs.getString("name") + "</td>");
                out.println("<td style='padding: 10px;'>" + rs.getString("dept") + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");


            con.close();
        } catch (Exception e) {
            out.println("<p style='color: red;'>Error: " + e.getMessage() + "</p>");
            e.printStackTrace(out);
        }
    }
}
