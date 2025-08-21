package com.example.demoRestCommDept;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public interface Department1Service {
	
	List<Department1> getAllDepartment1();
	Department1 addDepartment1(Department1 d);
	Department1 getDepartment1ById(int dno);

}
