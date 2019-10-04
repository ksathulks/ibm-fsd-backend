package com.examples.empapp.dao;

import com.examples.empapp.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeDB {

	ResultSet rs = null;

	@Autowired
	Connection connection;
	Statement stmt = null;
	PreparedStatement pstmt = null;

	public EmployeeDB() {
		// setConnection();
	}

	public void setConnection() {
		if (connection != null) {
			try {

				System.out.println("Connecting to database...");

				connection.setAutoCommit(true); // enable transaction
				System.out.println("Connection estabilished: " + connection);
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			}
		}

	}

	public void addEmpDB(Employee newEmp) {

		try {
			String insertQueryForPrepareStmt = "INSERT INTO employee (name, age, designation, department, country) VALUES (?, ?, ?, ?, ?)";
			pstmt = connection.prepareStatement(insertQueryForPrepareStmt);
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
			pstmt = connection.prepareStatement(sqlStmnt);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setDesign(rs.getString("designation"));
				emp.setDept(rs.getString("department"));
				emp.setCountry(rs.getString("country"));
			}

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return emp;

	}

	public void updateEmpDB(int id) {
		try {
			Scanner sc = new Scanner(System.in);
			String sqlStmnt = "UPDATE employee SET name= ?,age= ?,designation= ?,department=?,country= ? WHERE id = ?";
			pstmt = connection.prepareStatement(sqlStmnt);
			pstmt.setInt(6, id);
			System.out.println("Enter Name");
			pstmt.setString(1, sc.next());
			System.out.println("Enter Age");
			pstmt.setInt(2, sc.nextInt());
			System.out.println("Enter Designation");
			pstmt.setString(3, sc.next());
			System.out.println("Enter Department");
			pstmt.setString(4, sc.next());
			System.out.println("Enter Country");
			pstmt.setString(5, sc.next());

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Record Updated");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

	public void updateEmpDB(Employee emp) {
		try {
			Scanner sc = new Scanner(System.in);
			String sqlStmnt = "UPDATE employee SET name= ?,age= ?,designation= ?,department=?,country= ? WHERE id = ?";
			pstmt = connection.prepareStatement(sqlStmnt);
			pstmt.setInt(6, emp.getId());
			System.out.println("Enter Name");
			pstmt.setString(1, emp.getName());
			System.out.println("Enter Age");
			pstmt.setInt(2, emp.getAge());
			System.out.println("Enter Designation");
			pstmt.setString(3, emp.getDesign());
			System.out.println("Enter Department");
			pstmt.setString(4, emp.getDept());
			System.out.println("Enter Country");
			pstmt.setString(5, emp.getCountry());

			int updateCount = pstmt.executeUpdate();
			System.out.println(updateCount + " Record Updated");

		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}

	public void deleteEmpDB(int id) {
		try {
			String sqlStmnt = "delete from employee where id=?";
			pstmt = connection.prepareStatement(sqlStmnt);
			pstmt.setInt(1, id);

			int deleteCount = pstmt.executeUpdate();
			pstmt.close();
			if (deleteCount <= 0)
				System.out.println("Error in Deletion");
			System.out.println(deleteCount + " Employee(s) deleted");
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	public ArrayList<Employee> viewAllEmpDB() {
		ArrayList<Employee> empList = new ArrayList<>();
		try {
			String sqlStmnt = "SELECT * FROM employee";
			pstmt = connection.prepareStatement(sqlStmnt);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setAge(rs.getInt("age"));
				emp.setDesign(rs.getString("designation"));
				emp.setDept(rs.getString("department"));
				emp.setCountry(rs.getString("country"));
				empList.add(emp);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return empList;
	}

	public void importEmpF2DB(Employee eNew) {
		addEmpDB(eNew);
	}

}
