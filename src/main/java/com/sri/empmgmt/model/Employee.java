package com.sri.empmgmt.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;



@Entity
@NamedQuery(name="find_all_employees", query="select e from Employee e")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "empid")
	@GenericGenerator(name = "empid", strategy = "increment")
	private int emplId;
	private String empName;
	private float salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dept_id")
	private Department department;
	
	public Employee() {}
	
	public Employee(int emplId, String empName, float salary) {
		this.emplId = emplId;
		this.empName = empName;
		this.salary = salary;
	}

	public int getEmplId() {
		return emplId;
	}
	public void setEmplId(int emplId) {
		this.emplId = emplId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}	
}
