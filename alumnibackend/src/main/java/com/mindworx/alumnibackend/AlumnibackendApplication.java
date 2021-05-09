package com.mindworx.alumnibackend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AlumnibackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlumnibackendApplication.class, args);

        System.out.println("Connect to SQL Server for Read operation from AlumniDatabase.");        
        //connection string to database/server.
		String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=MINDWORX_AlumniAppDB;user=sa;password=Alumni";

        try {

            // Load SQL Server JDBC driver and establish connection.
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(connectionUrl)) {
                
                // READ demo
                System.out.print("Reading data from table, press ENTER to continue...");
                String sql = "SELECT UserID, UserName, UserEmail, UserSurname, UserDOB FROM Mindworx_Users;";
                try (Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        System.out.println(
                                resultSet.getInt(1) + " " + resultSet.getString(3) + " " + resultSet.getString(2) + " " + resultSet.getDate(5) + " " + resultSet.getString(4));
                    }
                }
                connection.close();
                System.out.println("All done.");
            
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }        
	}
	

}
 