package com.example.demoRestCommunication;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface Employee1Service {

	List<Employee1> getAllEmployees();
	Employee1 addEmployee(Employee1 e);
	Employee1 getEmployeeById(int id);
	EmployeeDTO getEmployeeUsingId(int id);
}
