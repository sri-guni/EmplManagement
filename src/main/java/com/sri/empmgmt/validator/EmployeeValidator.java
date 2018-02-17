package com.sri.empmgmt.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sri.empmgmt.model.Employee;

@Component
public class EmployeeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors err) {
		Employee emp = (Employee) obj;
		ValidationUtils.rejectIfEmptyOrWhitespace(err, "empName", "empl.name.empty");
	}

}
