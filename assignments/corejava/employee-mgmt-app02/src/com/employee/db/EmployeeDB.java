package com.employee.db;
import com.employee.services.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class EmployeeDB{
//	ResultSet rs = null;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	public void insert() {
		try {
			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setDatabaseName("jdbctraining");
			dataSource.setUser("training");
			dataSource.setPassword("training");
			dataSource.setServerName("localhost");

			// STEP 3: Open a conLeadnection
			System.out.println("Connecting to database...");
			conn = dataSource.getConnection();
			conn.setAutoCommit(false); // enable transaction

			System.out.println("Connection estabilished: " + conn);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			// Insertion with Prepared Statement
				EmployeeServices.empList.forEach(e->{
					String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
					try {
						pstmt = conn.prepareStatement(insertQueryForPrepareStmt);
					
						pstmt.setString(1, e.getName());
					
						pstmt.setInt(2, e.getAge());
					
						pstmt.setString(3, e.getDesign());
					
						pstmt.setString(4, e.getDept());
					
						pstmt.setString(5, e.getCountry());
					
						int insertCount = 0;
					
						insertCount = pstmt.executeUpdate();				
					
						pstmt.close();
					
					System.out.println(insertCount + " Employee(s) inserted");
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				});
				// persist the changes
				conn.commit();
			

			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
				
			}  // end try
			System.out.println("Goodbye!");
	}
}
	
