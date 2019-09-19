import com.employee.services.*;
public class EmployeeMain {

	public static void main(String[] args) {
		
		EmployeeServices e = new EmployeeServices();
		e.getInput();

	}

}
/*
 * - Project/Appp -> EmployeeMgmtApp / EmpMgmtSystem / EMS
 * - employee -> Employee
 * - Main -> EmployeeApp.java
 * - Main/Pojo -> Employee.java
 * - Service -> EmployeeService.java
 * - Service Impl -> EmployeeServiceImpl.java
 * 
 *  com.training.java.empapp <- EmployeeApp.java
 *  com.training.java.empap.model
 *  com.training.java.empap.service
 *  com.training.java.empap.dao
 *  com.training.java.empap.util
 *  
 *  2) Keep user interface logic out of service
 *  
 *  3) 
 * */