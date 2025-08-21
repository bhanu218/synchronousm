package com.example.demoRestCommDept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class Department1Controller {
	@Autowired
	Department1Service service;

	
	  @GetMapping("/alldept")
	    public List<Department1> getAllDepartment1() {
		  	return service.getAllDepartment1();
	  }
	  
	  
	  @GetMapping("/alldept/{id}")
	    public Department1 getDeptById(@PathVariable("id") int did) {
		  	return service.getDepartment1ById(did);
	  }
	  
	  @PostMapping("/adddept")
	  public Department1 addDepartment1(@RequestBody Department1 dept) {
		  	return service.addDepartment1(dept);
	  }
	

	
}
