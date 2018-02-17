package com.sri.empmgmt.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sri.empmgmt.model.Employee;
import com.sri.empmgmt.repository.DepartmentRepository;
import com.sri.empmgmt.repository.EmployeeRepository;
import com.sri.empmgmt.validator.EmployeeValidator;

@Controller
public class EmployeeController {

	@Autowired EmployeeRepository empRepository;
	@Autowired DepartmentRepository deptRepository;
	@Autowired EmployeeValidator validator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
	@RequestMapping(value="add-emp", method=RequestMethod.GET)
	public String showAddEmployeePage(ModelMap model) {
		model.put("emp", new Employee(0,"Employee Name",0.0f));
		model.put("dept", deptRepository.findAll());
		return "showemp";
	}
	
	@RequestMapping(value="add-emp", method=RequestMethod.POST)
	public String addEmployee(ModelMap model, @Valid @ModelAttribute("emp") Employee emp, BindingResult result) {
		
		if(result.hasErrors()) {
			return "showemp";
		}
		
		empRepository.update(emp);
		return "redirect:/list-emps";
	}

	@RequestMapping(value="update-emp", method=RequestMethod.GET)
	public String showUpdateEmployeePage(@RequestParam int id, ModelMap model) {
		model.put("emp", empRepository.findById(id));
		model.put("dept", deptRepository.findAll());
		return "showemp";
	}

	@RequestMapping(value="update-emp", method=RequestMethod.POST)
	public String updateEmployee(ModelMap model, @Valid Employee empl, BindingResult result) {

		if (result.hasErrors()) {
			return "showemp";
		}

		empRepository.update(empl);
		
		return "redirect:/list-emps";
	}
	
	@RequestMapping(value="delete-emp", method=RequestMethod.GET)
	public String deleteEmployee(@RequestParam int id) {
		empRepository.deleteById(id);
		return "redirect:/list-emps";
	}
	
	@RequestMapping(value="list-emps", method = RequestMethod.GET)
	public String viewEmployees(ModelMap model) {
		model.put("employees", empRepository.getAllEmployees());
		return "viewempl";
	}
	
}
