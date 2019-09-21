package com.employee.services;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import com.employee.structures.Employee;;

public class EmployeeServices {
	HashMap<Integer,Employee> empCollection = new HashMap<Integer,Employee>();
	
	public void addEmp(Employee newEmp) {
		empCollection.put(newEmp.getId(), newEmp);		
	}
	
	public void viewEmp(int id) {
		if(empCollection.containsKey(id)) {
			Employee e = empCollection.get(id);
			System.out.println(e);
		}
		else {
			System.out.println("Employee with the given id is not found!!!");
		}
	}
	
	public void updateEmp(int id) {
		if(empCollection.containsKey(id)) {
			Scanner sc = new Scanner(System.in);
			Employee e = empCollection.get(id);
			System.out.println("Enter Id");
			e.setId(sc.nextInt());
			System.out.println("Enter Name");
			e.setName(sc.next());
			System.out.println("Enter Age");
			e.setAge(sc.nextInt());
			System.out.println("Enter Designation");
			e.setDesign(sc.next());
			System.out.println("Enter Department");
			e.setDept(sc.next());
			System.out.println("Enter Country");
			e.setCountry(sc.next());
		}
		else {
			System.out.println("Employee with the given id is not found!!!");
		}
	}
	
	public void deleteEmp(int id) {
		if(empCollection.containsKey(id)) {
			empCollection.remove(id);
		}
		else {
			System.out.println("Employee with the given id is not found!!!");
		}
	}
	
	public void viewAllEmp() {
		for(Employee e : empCollection.values()) {
			System.out.println(e);
		}
		if (empCollection.isEmpty()) {
			System.out.println("Employee records is empty!!!");
		}
	}
	
	public void exportEmp() {
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\employeeFile.txt");
			for(Employee e : empCollection.values()) {
				String objlist = String.format("%d,%s,%d,%s,%s,%s", e.getId(),e.getName(),e.getAge(),e.getDesign(),e.getDept(),e.getCountry());
				System.out.println(objlist);
				fileOut.write(objlist.getBytes());
				fileOut.write("\n".getBytes());
			}	
			fileOut.close();
		}
		catch (FileNotFoundException e) {			
			e.printStackTrace();
		}catch (IOException i){
			i.printStackTrace();
		}
		
	}
	
	public void importEmp() {
		Scanner s= new Scanner(System.in);
        try {
        	s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\employeeFile.txt"))));
        	while (s.hasNextLine()) {
		        String[] empArr = s.nextLine().split(",");                
                Employee eNew= new Employee(Integer.parseInt(empArr[0]), empArr[1], Integer.parseInt(empArr[2]), empArr[3], empArr[4], empArr[5] );
                empCollection.put(eNew.getId(), eNew);
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