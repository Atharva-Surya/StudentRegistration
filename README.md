# StudentRegistration

Student Registration System
Overview
This is a simple web-based Student Registration System implemented using Java Servlets and MySQL. It allows users to add student details (Roll No, Name, Department) via a web form and stores the data in a MySQL database. The system also displays all registered students in a formatted table.

Features
Student registration form with input validation.

Data persistence using MySQL.

Dynamic creation of the student table if it doesn’t exist.

Displays all registered students with their Roll No, Name, and Department.

Basic error handling for database and servlet operations.

Technologies Used
Java Servlet API

MySQL Database

JDBC (Java Database Connectivity)

HTML and CSS (for frontend form)

Apache Tomcat (or any Servlet container)

Prerequisites
Java JDK (version 8 or above)

Apache Tomcat server or any compatible Servlet container

MySQL Server installed and running

IDE or text editor for Java development (Eclipse, IntelliJ IDEA, VS Code, etc.)

Setup and Installation
Clone the repository

bash
Copy
Edit
git clone https://github.com/your-username/student-registration.git
cd student-registration
Create MySQL database

Log into MySQL and create the database used by the project (if not already created):

sql
Copy
Edit
CREATE DATABASE servlet_jdbc;
Update database credentials

Modify the StudentServlet.java file to set your MySQL username and password:

java
Copy
Edit
String user = "root";       // Change if necessary
String password = "root123"; // Change if necessary
Build and deploy

Build your project (using Maven/Gradle or your IDE).

Deploy the WAR file or project to your servlet container (e.g., Tomcat).

Run the application

Access the registration form at:

bash
Copy
Edit
http://localhost:8080/your-app-context/index.html
Fill in the form and submit to register a new student.

After submission, the list of all registered students will be displayed.

Usage
Fill out the Roll No, Name, and Department fields.

Click Register to submit the form.

View all registered students listed below the form submission confirmation.

Troubleshooting
Make sure MySQL server is running and accessible.

Ensure the database credentials in StudentServlet.java are correct.

If the student table already exists, the servlet will not recreate it.

Check the Tomcat logs for any servlet-related errors.

Future Enhancements
Add input validation on both client and server sides.

Implement update and delete functionality for students.

Add search and pagination to the students list.

Use JSP or frontend frameworks for better UI.

Secure the application with authentication and authorization.
