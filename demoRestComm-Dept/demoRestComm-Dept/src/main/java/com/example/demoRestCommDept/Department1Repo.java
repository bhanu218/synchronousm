package com.example.demoRestCommDept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Department1Repo extends JpaRepository<Department1, Integer>{

}
