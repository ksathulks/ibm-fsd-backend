import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.employee.services.EmployeeServices;
import com.employee.structures.Employee;
public class EmployeeMain {
	
	public static Employee readEmp() {
		Scanner sc=new Scanner(System.in);
		Employee newEmp = new Employee();
		
		System.out.println("Enter Id");
		newEmp.setId(sc.nextInt());
		System.out.println("Enter Name");
		newEmp.setName(sc.next());
		System.out.println("Enter Age");
		newEmp.setAge(sc.nextInt());
		System.out.println("Enter Designation");
		newEmp.setDesign(sc.next());
		System.out.println("Enter Department");
		newEmp.setDept(sc.next());
		System.out.println("Enter Country");
		newEmp.setCountry(sc.next());
		return newEmp;
	}

	public static void main(String[] args) {
		
		EmployeeServices empService = new EmployeeServices();
		int choice=0;
		do {
			try {
				Scanner sc=new Scanner(System.in);
				System.out.println("Enter 1 to add / 2 to view / 3 to update / 4 to delete / 5 to view all / 6 to import file-2-DB / 7 to export DB-2-file --> Employee / 10 to exit");
				choice = sc.nextInt();				
				switch(choice) {
					case 1:
						try {
							empService.addEmp(readEmp());							
						}
						catch(InputMismatchException e){
							System.out.println("Please Enter valid value ");
						}
						break;
						
					case 2:
						try {
							System.out.println("Enter Emp Id");
							System.out.println(empService.viewEmp(sc.nextInt()));
						}
						catch(InputMismatchException e){
							System.out.println("Please Enter valid value ");
						}						
						break;
						
					case 3:
						try {
							System.out.println("Enter Emp Id");
							empService.updateEmp(sc.nextInt());
						}
						catch(InputMismatchException e){
							System.out.println("Please Enter a valid value ");
						}						
						break;
						
					case 4:
						try {
							System.out.println("Enter Emp Id");
							empService.deleteEmp(sc.nextInt());
						}
						catch(InputMismatchException e)	{
							System.out.println("Please Enter a valid value");
						}						
						break;
						
					case 5:
						empService.viewAllEmp();
						break;
						
					case 6:
						class Sample implements Callable<String> {							
							public String call() throws Exception {							
								empService.importEmp();						
								return "Successfully Imported";														
							}
						}						
						
						Callable<String> c1 = new Sample();						
						ExecutorService e1 = Executors.newFixedThreadPool(1);						
						Future f =  e1.submit(c1);
						
						while(!f.isDone()) {
							String s =null;
							try {
								s=(String) f.get();
							} catch (InterruptedException ex1) {
								// TODO Auto-generated catch block
								ex1.printStackTrace();
							} catch (ExecutionException ex1) {
								// TODO Auto-generated catch block
								ex1.printStackTrace();
							}
							System.out.println(s);							
							e1.shutdown();
						}												
						break;
						
					case 7:
						class Sample implements Callable<String> {							
							public String call() throws Exception {								
								empService.exportEmp();						
								return "Successfully Exported";							
							}
						}
												
						Callable<String> c2 = new Sample();						
						ExecutorService e2 = Executors.newFixedThreadPool(1);						
						Future f2 =  e2.submit(c2);
						
						while(!f2.isDone()){
							String s =null;
							try {
								s=(String) f2.get();
							} catch (InterruptedException ex2) {
								// TODO Auto-generated catch block
								ex2.printStackTrace();
							} catch (ExecutionException ex2) {
								// TODO Auto-generated catch block
								ex2.printStackTrace();
							}
							System.out.println(s);						
							e2.shutdown();
						}						
						break;
						
					case 10:
						System.out.println("Exiting............Thank you");
						break;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("Please Enter valid value");
			}
			
		}while(choice!=10);
		
	}

}