package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.dao.NewEmployeeDao;
import com.example.spring.model.NewEmployee;

/****IMPORTANT NOTE****/
/*
 * Most interesting part above is @Transactional which starts a transaction
 * on each method start, and commits it on each method exit 
 * ( or rollback if method was failed due to an error). 
 * Note that since the transaction are on method scope, 
 * and inside method we are using DAO, DAO method will be executed within same transaction.
 * */
/**** IMPORTANT NOTE ****/

@Service("newEmployeeService")
@Transactional
public class NewEmployeeServiceImpl implements NewEmployeeService {

	@Autowired
	private NewEmployeeDao dao;

	/*** IMPORTANT NOTE */
	/*
	 * what is the mechanism to inject NewEmployeeDao dependency?
	 * */
	/*
	 * It's more towards Spring promoting programming to interfaces.
	 * NewEmployeeDaoImpl Bean is an implementation of NewEmployeeDao which
	 * would eventually be injected wherever asked. Eventually if you more than
	 * one implementation of that interface, then while injecting, you would
	 * need to specify which one Spring should be injecting using @Qualifier
	 */

	public void saveEmployee(NewEmployee employee) {
		dao.saveEmployee(employee);
	}

	public List<NewEmployee> findAllEmployees() {
		return dao.findAllEmployees();
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployeeBySsn(ssn);
	}

	public NewEmployee findBySsn(String ssn) {
		return dao.findBySsn(ssn);
	}

	public void updateEmployee(NewEmployee employee) {
		dao.updateEmployee(employee);
	}
}
