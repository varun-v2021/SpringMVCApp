package com.example.spring.app;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.example.spring.config.AppConfig;
import com.example.spring.domain.Application;
import com.example.spring.domain.Bond;
import com.example.spring.domain.Driver;
import com.example.spring.model.Employee;
import com.example.spring.model.NewEmployee;
import com.example.spring.service.EmployeeService;
import com.example.spring.service.FileService;
import com.example.spring.service.NewEmployeeService;

public class AppMain {

	public static void main(String args[]) {
		AbstractApplicationContext context1 = new 
				AnnotationConfigApplicationContext(AppConfig.class);

		//to demo event handling
		context1.start();
		
		// Byname Autowiring
		Application application = (Application) context1.getBean("application");
		System.out.println("Application Details : " + application);
		
		Driver driver = (Driver) context1.getBean("driver");
        System.out.println("Driver Details : " + driver);
        
        Bond bond = (Bond) context1.getBean("bond");
        bond.showCar();
        
        FileService service1 = (FileService) context1.getBean("fileService");
        service1.readValues();
        
        EmployeeService eService = (EmployeeService) context1.getBean("employeeService");
        
        /*
         * Register employee using service
         */
        Employee employee3 = new Employee();
        employee3.setName("Danny Theys");
        eService.registerEmployee(employee3);
        
		//to demo event handling
        context1.stop();
        
        context1.close(); 
        
        hibernateIntegrationCall();
        
	}
	
	public static void hibernateIntegrationCall(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		 
        NewEmployeeService service = (NewEmployeeService) context.getBean("newEmployeeService");
 
        /*
         * Create Employee1
         */
        NewEmployee employee1 = new NewEmployee();
        employee1.setName("Han Yenn");
        employee1.setJoiningDate(new Date(2010, 10, 10));
        employee1.setSalary(new BigDecimal(10000));
        employee1.setSsn("ssn00000001");
 
        /*
         * Create Employee2
         */
        NewEmployee employee2 = new NewEmployee();
        employee2.setName("Dan Thomas");
        employee2.setJoiningDate(new Date(2012, 11, 11));
        employee2.setSalary(new BigDecimal(20000));
        employee2.setSsn("ssn00000002");
 
        /*
         * Persist both Employees
         */
        service.saveEmployee(employee1);
        service.saveEmployee(employee2);
 
        /*
         * Get all employees list from database
         */
        List<NewEmployee> employees = service.findAllEmployees();
        for (NewEmployee emp : employees) {
            System.out.println(emp);
        }
 
        /*
         * delete an employee
         */
        service.deleteEmployeeBySsn("ssn00000002");
 
        /*
         * update an employee
         */
 
        NewEmployee employee = service.findBySsn("ssn00000001");
        employee.setSalary(new BigDecimal(50000));
        service.updateEmployee(employee);
 
        /*
         * Get all employees list from database
         */
        List<NewEmployee> employeeList = service.findAllEmployees();
        for (NewEmployee emp : employeeList) {
            System.out.println(emp);
        }
 
        context.close();
    }

}