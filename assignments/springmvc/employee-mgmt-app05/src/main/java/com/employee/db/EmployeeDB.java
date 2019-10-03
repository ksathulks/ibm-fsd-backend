package com.employee.db;
import com.employee.structures.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class EmployeeDB{
	ResultSet rs = null;
	
	Connection conn;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	
	public EmployeeDB() {
		setConnection();
	}
	
	public void setConnection() {
		if(conn==null) {
			try {
//				conn=dataSource.getConnection();
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setDatabaseName("jdbctraining");
				dataSource.setUser("training");
				dataSource.setPassword("training");
				dataSource.setServerName("localhost");

				// STEP 3: Open a conLeadnection
				System.out.println("Connecting to database...");
				conn = dataSource.getConnection();
				conn.setAutoCommit(true); // enable transaction
				System.out.println("Connection estabilished: " + conn);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			}
		}
		
	}
	
	public void addEmpDB(Employee newEmp) {					
					
					try {
						String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
						pstmt = conn.prepareStatement(insertQueryForPrepareStmt);					
						pstmt.setString(1, newEmp.getName());					
						pstmt.setInt(2, newEmp.getAge());					
						pstmt.setString(3, newEmp.getDesign());					
						pstmt.setString(4, newEmp.getDept());					
						pstmt.setString(5, newEmp.getCountry());					
						int insertCount = pstmt.executeUpdate();					
						pstmt.close();
					
					System.out.println(insertCount + " Employee(s) inserted");
					} catch (SQLException se) {
						// TODO Auto-generated catch block
						se.printStackTrace();
					}
	}

	public Employee viewEmpDB(int id) {
		Employee emp = new Employee();
		try {
			String sqlStmnt = "SELECT * FROM employee WHERE id=?";
			pstmt = conn.prepareStatement(sqlStmnt);			
			pstmt.setInt(1,id);			
			rs = pstmt.executeQuery();			
			
			while(rs.next()){
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setDesign( rs.getString("designation"));
				emp.setDept(rs.getString("department"));
				emp.setCountry(rs.getString("country"));
				}
			
			}catch(SQLException se){
				System.out.println(se.getMessage());
			}
		return emp;
			
	}
	
	public void updateEmpDB(int id) {
		try
		{
			Scanner sc = new Scanner(System.in);
			String sqlStmnt = "UPDATE employee SET name= ?,age= ?,designation= ?,department=?,country= ? WHERE id = ?";
			pstmt = conn.prepareStatement(sqlStmnt);
			pstmt.setInt(6,id);
			System.out.println("Enter Name");
			pstmt.setString(1,sc.next());
			System.out.println("Enter Age");
			pstmt.setInt(2,sc.nextInt());
			System.out.println("Enter Designation");
			pstmt.setString(3,sc.next());
			System.out.println("Enter Department");
			pstmt.setString(4,sc.next());
			System.out.println("Enter Country");
			pstmt.setString(5,sc.next());
			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" Record Updated");
			
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}		
	}
	
	public void updateEmpDB(int id, Employee e) {
		try
		{
			
			String sqlStmnt = "UPDATE employee SET name= ?,age= ?,designation= ?,department=?,country= ? WHERE id = ?";
			pstmt = conn.prepareStatement(sqlStmnt);
			pstmt.setInt(6,id);			
			pstmt.setString(1,e.getName());			
			pstmt.setInt(2,e.getAge());			
			pstmt.setString(3,e.getDesign());			
			pstmt.setString(4,e.getDept());			
			pstmt.setString(5,e.getCountry());			
			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount+" Record Updated");
			
		}catch(SQLException se){
			System.out.println(se.getMessage());
		}		
	}
	
	public void deleteEmpDB(int id) {
			try {				
				String sqlStmnt="delete from employee where id=?";
				pstmt=conn.prepareStatement(sqlStmnt);
				pstmt.setInt(1, id);
				
				int deleteCount = pstmt.executeUpdate();
				pstmt.close();
				if(deleteCount<=0)
					System.out.println("Error in Deletion");
				System.out.println(deleteCount + " Employee(s) deleted");
				}
				catch (SQLException se) {
					se.printStackTrace();
				}
		}
	
	public ArrayList<Employee> viewAllEmpDB(){
		ArrayList<Employee> empList = new ArrayList<>();
		try {
			String sqlStmnt = "SELECT * FROM employee";
			pstmt = conn.prepareStatement(sqlStmnt);		
			rs = pstmt.executeQuery();			
			
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setDesign( rs.getString("designation"));
				emp.setDept(rs.getString("department"));
				emp.setCountry(rs.getString("country"));			
				empList.add(emp);
				}
		}catch (SQLException se) {
			se.printStackTrace();
		}
		return empList;		
	}
	
	public void importEmpF2DB(Employee eNew) {
		addEmpDB(eNew);
	}
	
}
	
