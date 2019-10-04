package com.examples.empapp.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.examples.empapp.dao.*;
import com.examples.empapp.model.*;

public class EmployeeServices {
	@Autowired
	EmployeeDB empDao;
	HashMap<Integer, Employee> empCollection = new HashMap<Integer, Employee>();

	public void addEmp(Employee newEmp) {
		empCollection.put(newEmp.getId(), newEmp);
		empDao.addEmpDB(newEmp);
	}

	public Employee viewEmp(int id) {
		return empDao.viewEmpDB(id);
	}

	public void updateEmp(int id) {
		empDao.updateEmpDB(id);
	}

	public void updateEmp(Employee emp) {
		empDao.updateEmpDB(emp);
	}

	public void deleteEmp(int id) {
		empDao.deleteEmpDB(id);
	}

	public void viewAllEmp() {
		empDao.viewAllEmpDB().forEach(e -> {
			System.out.println(e);
		});
	}

	public ArrayList<Employee> getAll() {

		return empDao.viewAllEmpDB();
	}

	public void exportEmp() {
		try {
			ArrayList<Employee> empList = empDao.viewAllEmpDB();
			FileOutputStream fileOut = new FileOutputStream(
					"C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app02\\src\\employeeFile.txt");
			empList.forEach(e -> {
				String objlist = String.format("%d,%s,%d,%s,%s,%s", e.getId(), e.getName(), e.getAge(), e.getDesign(),
						e.getDept(), e.getCountry());
				System.out.println(objlist);
				try {
					fileOut.write(objlist.getBytes());
					fileOut.write("\n".getBytes());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	public void importEmp() {
		Scanner s = new Scanner(System.in);
		try {
			s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(
					"C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app02\\src\\employeeFile.txt"))));
			while (s.hasNextLine()) {
				String[] empArr = s.nextLine().split(",");
				Employee eNew = new Employee(Integer.parseInt(empArr[0]), empArr[1], Integer.parseInt(empArr[2]),
						empArr[3], empArr[4], empArr[5]);
				empDao.importEmpF2DB(eNew);
			}
			viewAllEmp();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (s != null) {
				s.close();
			}
		}

	}

}