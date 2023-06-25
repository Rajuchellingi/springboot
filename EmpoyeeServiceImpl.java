package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRespository;

@Service
public class EmpoyeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRespository employeerepository;

	@Override
	public List<Employee> getallEmployee() {
         
		return employeerepository.findAll();
	}


	@Override
	public void saveemployee(Employee employee) {
		// TODO Auto-generated method stub
			
		this.employeerepository.save(employee);
		}




	}
