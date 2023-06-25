package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeservice;
	//to display list of employees
	
	//public List<Employee> viewhomepage(@RequestBody Employee employee) {
	//	modeaddAttribute("listofEmployees",
		//	return	employeservice.getallEmployee();
	@GetMapping("/")
	public String viewhomepage(Model model) {
		model.addAttribute("listEmployees", employeservice.getallEmployee());
		return "index";
	}
		@GetMapping("/shownewemployeeform")	
	public String shownewemployee(Model model) {
			//create model to bind form data
			Employee employee=new Employee();
			//below thymeleaf string employee template will access empty employee object for binding data
			model.addAttribute("employee", employee);
		return "savemethod";
		
	}
	
		
      @PostMapping("/saveEmployee")
		public String saveemployee(@ModelAttribute("employee") Employee employee) {
    	  //save employee to database
    	
    	  employeservice.saveemployee(employee);
    	  
			return "redirect:/";
			
      }
	}
