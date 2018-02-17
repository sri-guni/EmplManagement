package com.sri.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sri.empmgmt.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
}
