package com.sri.empmgmt.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sri.empmgmt.model.Employee;

@Repository
@Transactional
public class EmployeeRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<Employee> getAllEmployees() {
		TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("find_all_employees", Employee.class);
		List<Employee> empList = namedQuery.getResultList();
		return empList;		
	}
	
	public Employee findById(int emplId) {
		Employee empl = entityManager.find(Employee.class, emplId);
		System.out.println("Dept No=>" + empl.getDepartment().getDeptId());
		return empl;
	}
	
	public Employee update(Employee empl) {
		return entityManager.merge(empl);
	}
	
	public void deleteById(int emplId) {
		Employee temp = findById(emplId);
		entityManager.remove(temp);
	}
}
