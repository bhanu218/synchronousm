package com.example.demoRestCommunication;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class Employee1ServiceImpl  implements Employee1Service{
	@Autowired
	Employee1Repo repo;
	
	@Autowired
	RestTemplate rt;

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
		ResponseEntity<Department1> dept1;
		
		if(op.isPresent()) {
			 dept1=rt.getForEntity("http://localhost:7070/dept/alldept/"+op.get().getDeptno(), Department1.class);
		
			System.out.println(dept1.getBody().getDeptno()+dept1.getBody().getDname()+dept1.getBody().getLoc());

			
			return (Employee1) op.get();
		}
		else
			return null;
	}
	
	
	@Override
	public EmployeeDTO getEmployeeUsingId(int id) {
				System.out.println("============================================================");
		Optional<Employee1> op = repo.findById(id);
		ResponseEntity<Department1> dept1;
		EmployeeDTO emp;
		
		if(op.isPresent()) {
			 emp = new EmployeeDTO();
			
			 dept1=rt.getForEntity("http://localhost:7070/dept/alldept/"+op.get().getDeptno(), Department1.class);
		
			System.out.println(dept1.getBody().getDeptno()+dept1.getBody().getDname()+dept1.getBody().getLoc());
			emp.setEmpno(   op.get().getEmpno() );
			emp.setEname(  	op.get().getEname() );
			emp.setJob( 	op.get().getJob() );
			emp.setDeptno(  dept1.getBody().getDeptno()  );
			emp.setDname(   dept1.getBody().getDname()   );
			emp.setLoc(    	dept1.getBody().getLoc()     );

			
			return emp;
		}
		else
			return null;
	}
	

}
