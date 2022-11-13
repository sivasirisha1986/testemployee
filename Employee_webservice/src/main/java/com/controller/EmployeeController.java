package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.model.Employee;
import com.service.EmployeeService;



@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
	 @RequestMapping("/")
	    public ModelAndView viewHomePage(Model model) {
	        List<Employee> employeeList = employeeService.getAllEmployees();
	        model.addAttribute("listAll", employeeList);
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.setViewName("index.html");
	        return modelAndView;
	    }
	@RequestMapping(value="/showNewEmployeeForm")
	public ModelAndView  showNewEmployeeForm(Model model) {
		
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("NewEmployee.html");
        return modelAndView;
		
	}
	
	@RequestMapping(value="/saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("NewEmployee.html");
        return modelAndView;
	}
	
	
	
}