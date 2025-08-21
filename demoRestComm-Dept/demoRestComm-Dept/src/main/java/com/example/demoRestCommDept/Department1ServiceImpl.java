package com.example.demoRestCommDept;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Department1ServiceImpl implements Department1Service{
	@Autowired
	Department1Repo repo;

	@Override
	public List<Department1> getAllDepartment1() {
		// TODO Auto-generated method stub
		return (List<Department1>) repo.findAll();
	}

	@Override
	public Department1 addDepartment1(Department1 d) {
		return repo.save(d);
	}

	@Override
	public Department1 getDepartment1ById(int dno) {
		Optional<Department1> dept= repo.findById(dno);
		if(dept.isPresent())
			return dept.get();
		else
			return null;
	}

}
