import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmpService {
	List<Employee> empList = new ArrayList<Employee>();
	public void getInput() {
		Scanner sc=new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter 1 to add, 2 to view, 3 to update, 4 to delete, 5 to view all, 6 to import, 7 to export, 10 to exit");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					addNewEmp();
					break;
				case 2:
					System.out.println("Enter Emp Id");
					int x= sc.nextInt();
					view(x);
					break;
				case 3:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					update(x);
					break;
				case 4:
					System.out.println("Enter Emp Id");
					x= sc.nextInt();
					delete(x);
					break;
				case 5:
					viewAll();
					break;
				case 6:
					importEmp();
					break;
				case 7:
					exportEmp();
					break;
				case 10:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid entry please try again!!");
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
			FileOutputStream fileOut = new FileOutputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\newFile.txt");
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
		catch (IOException i){
			i.printStackTrace();
		}
		
	}
	
	public void importEmp() {
		Scanner s= new Scanner(System.in);
        try {
        	s = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Training\\ibm-fsd-backend\\assignments\\corejava\\employee-mgmt-app01\\newFile.txt"))));
        	
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
