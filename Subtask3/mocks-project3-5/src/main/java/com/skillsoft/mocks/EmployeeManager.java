package com.skillsoft.mocks;

import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
	
	private List<Employee> employeeList = new ArrayList<>();
	private String databaseConnectionString;
	
	public EmployeeManager(String databaseConnectionString) {
		this.databaseConnectionString = databaseConnectionString;
	}
	
	public void addEmployee(Employee employee) {
		
		employeeList.add(employee);
		
		employee.saveToDatabase(databaseConnectionString);
	}
	
	public void removeEmployeeByName(String name) {
		
		for(Employee e : employeeList) {
			
			if(e.getName().equals(name)) {
				
					employeeList.remove(e);
			        e.deleteFromDatabase(databaseConnectionString);
			        
			        break;
			}
		}	
	}
	
	public boolean employeeExists(String name) {
		for(Employee e : employeeList) {
			if(e.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
