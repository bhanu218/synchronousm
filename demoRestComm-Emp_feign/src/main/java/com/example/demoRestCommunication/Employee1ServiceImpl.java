package com.example.demoRestCommunication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;



@Service
public class Employee1ServiceImpl  implements Employee1Service{
	@Autowired
	Employee1Repo repo;
	
	@Autowired
	ApiClients apiclient;

	@Override
	public List<Employee1> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee1>) repo.findAll();
	}

	@Override
	public Employee1 addEmployee(Employee1 e) {
		
		return repo.save(e);
	}

	@Override
	public Employee1 getEmployeeById(int id) {
				System.out.println("============================================================");
		Optional<Employee1> op = repo.findById(id);
		//Mono<Department1> dept1;
		
		if(op.isPresent()) {
			Department1	 dept1= apiclient.getDeptById(op.get().getDeptno());
					 
		
			System.out.println(dept1.getDeptno()+dept1.getDname()+dept1.getLoc());

			
			return (Employee1) op.get();
		}
		else
			return null;
	}
	
	
	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
				System.out.println("============================================================");
		Optional<Employee1> op = repo.findById(id);
//		ResponseEntity<Department1> dept1;
		EmployeeDTO emp;
		
		if(op.isPresent()) {
			 emp = new EmployeeDTO();
		
			 Department1	 dept1= apiclient.getDeptById(op.get().getDeptno());

				
			System.out.println(dept1.getDeptno()+dept1.getDname()+dept1.getLoc());
			emp.setEmpno(   op.get().getEmpno() );
			emp.setEname(  	op.get().getEname() );
			emp.setJob( 	op.get().getJob() );
			emp.setDeptno(  dept1.getDeptno()  );
			emp.setDname(   dept1.getDname()   );
			emp.setLoc(    	dept1.getLoc()     );

			
			return emp;
		}
		else
			return null;
	}
	

}
