package com.employee.services;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.employee.structures.*;

public class EmployeeServices {
	List<Employee> empList = new ArrayList<Employee>();
	public void getInput() {
		
		int choice = 0;
		do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter 1 to add, 2 to view, 3 to update, 4 to delete, 5 to view all, 6 to import, 7 to export, 10 to exit");
				choice = sc.nextInt();
				
				switch(choice) {
					case 1:
						try {
							addNewEmp();
						}
						catch(InputMismatchException iME)
						{
							System.out.println("Please Enter a numeric Value");
						}
						break;
					case 2:
						try {
							System.out.println("Enter Emp Id");
							int x= sc.nextInt();
							view(x);
							}
						catch(InputMismatchException iME1)
						{
							System.out.println("Please Enter a numeric Value");
						}
						
						break;
					case 3:
						try {
							System.out.println("Enter Emp Id");
							int x= sc.nextInt();
							update(x);
							}
						catch(InputMismatchException iME1)
						{
							System.out.println("Please Enter a numeric Value");
						}
						
						break;
					case 4:
						try {
							System.out.println("Enter Emp Id");
							int x= sc.nextInt();
							delete(x);
							}
						catch(InputMismatchException iME1)
						{
							System.out.println("Please Enter a numeric Value");
						}
						
						break;
					case 5:
						viewAll();
						break;
					case 6:
						class Sample implements Callable<String>
						{							
							public String call() throws Exception 
							{							
								importEmp();						
								return "Successfully Imported";						
														
							}
						}						
						
						Callable<String> c1 = new Sample();
						
						ExecutorService e = Executors.newFixedThreadPool(1);
						
						Future f =  e.submit(c1);
						
						while(!f.isDone())
						{
							String s =null;
							try {
								s=(String) f.get();
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (ExecutionException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							System.out.println(s);							
							e.shutdown();
						}
						
						break;
					case 7:
						class Sample implements Callable<String>{							
							public String call() throws Exception {								
								exportEmp();						
								return "Successfully Exported";							
							}
						}
												
						Callable<String> c2 = new Sample();
						
						ExecutorService e1 = Executors.newFixedThreadPool(1);
						
						Future f2 =  e1.submit(c2);
						
						while(!f2.isDone())
						{
							String s =null;
							try {
								s=(String) f2.get();
							} catch (InterruptedException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							} catch (ExecutionException e2) {
								// TODO Auto-generated catch block
								e2.printStackTrace();
							}
							System.out.println(s);
						
							e1.shutdown();			

						}
						
						break;
					case 10:
						System.out.println("Exiting...");
						break;
				}
			}
			catch(InputMismatchException iME)
			{
				System.out.println("Please Enter a numeric Value");
			}
			
		}while(choice!=10);
	}
	public void addNewEmp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Id");
		int nId=sc.nextInt();
		System.out.println("Enter Name");
		String nName=sc.next();
		System.out.println("Enter Age");
		int nAge=sc.nextInt();
		System.out.println("Enter Designation");
		String nDesign=sc.next();
		System.out.println("Enter Department");
		String nDept=sc.next();
		System.out.println("Enter Country");
		String nCountry=sc.next();
		Employee newEmp = new Employee(nId, nName, nAge, nDesign, nDept, nCountry);
		empList.add(newEmp);
		
	}
	
	public void view(int x) {
		empList.forEach(e->{if(e.getId()==x) {
			System.out.println(e);
		}});
	}
	
	public void update(int x) {
		delete(x);
		addNewEmp();		
	}
	
	public void delete(int x) {
		Iterator<Employee> itr = empList.iterator();
		while (itr.hasNext()) {
		    Employee e = itr.next();
		       if (e.getId() == x) {
		       itr.remove();
		    }

		}
	}
	
	public void viewAll() {
		empList.forEach(e->{
			System.out.println(e);
		});
	}
	public void exportEmp() {
		try {
			FileOutputStream fileOut = new FileOutputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\newFile.txt");
			empList.forEach(e->{
				try {
					String objlist = String.format("%d,%s,%d,%s,%s,%s", e.getId(),e.getName(),e.getAge(),e.getDesign(),e.getDept(),e.getCountry());
					System.out.println(objlist);
					fileOut.write(objlist.getBytes());
					fileOut.write("\n".getBytes());
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			});
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
        	s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\src\\newFile.txt"))));
        	
            while (s.hasNextLine()) {
		        String[] empArr = s.nextLine().split(",");    	
//                System.out.println(s.nextLine());
                
                Employee eNew= new Employee(Integer.parseInt(empArr[0]), empArr[1], Integer.parseInt(empArr[2]), empArr[3], empArr[4], empArr[5] );
                empList.add(eNew);
            }
            viewAll();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
            if (s != null) {
                s.close();
            }
        }
		
        		
	}
	
	

}