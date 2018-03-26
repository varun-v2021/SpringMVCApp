package com.example.spring.dao;

import java.util.List;

import com.example.spring.model.Employee;
import com.example.spring.model.NewEmployee;

public interface NewEmployeeDao {

	void saveEmployee(NewEmployee employee);

	List<NewEmployee> findAllEmployees();

	void deleteEmployeeBySsn(String ssn);

	NewEmployee findBySsn(String ssn);

	void updateEmployee(NewEmployee employee);
}