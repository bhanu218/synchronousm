package com.example.demoRestCommunication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class Employee1Controller {
	
	@Autowired
	Employee1Service service;
	
	  @GetMapping("/employees")
	    public List<Employee1> getAllEmployees() {
		  	return service.getAllEmployees();
	  }
	  
	  
	  @GetMapping("/employee/{id}")
	    public Employee1 getEmpById(@PathVariable("id") int eid) {
		  	return service.getEmployeeById(eid);
	  }
	  
	  @PostMapping("/addEmployee")
	  public Employee1 addEmployee(@RequestBody Employee1 emp) {
		  	return service.addEmployee(emp);
	  }
	
	//-----------------------------------------
	  
	  @GetMapping("/complete/{id}")
	    public ResponseEntity<?> getEmployeeUsingId(@PathVariable("id") int eid) {
		  	EmployeeDTO emp=  service.getEmployeeUsingId(eid);
		  	
			  if(emp!=null)
				  return new ResponseEntity<>(emp,HttpStatus.OK);
			  else
				  return new ResponseEntity<>("Employee object not found with given Id/not",HttpStatus. INTERNAL_SERVER_ERROR);
			  }
	  
	  
	  
	  
	  
	  

}
