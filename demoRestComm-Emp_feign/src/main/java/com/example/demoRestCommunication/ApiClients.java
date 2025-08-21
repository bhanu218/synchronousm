package com.example.demoRestCommunication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


// creating a feign client


@FeignClient(url="http://localhost:7070",value="DEPARTMENT-SERVICE")
public interface ApiClients {
		
	  @GetMapping("/dept/alldept/{id}")
	    public Department1 getDeptById(@PathVariable("id") int did);
}
