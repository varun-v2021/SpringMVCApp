package com.example.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Employee;
import com.example.spring.model.NewEmployee;

@Repository("newEmployeeDao")

public class NewEmployeeDaoImpl extends AbstractDao implements NewEmployeeDao {

	public void saveEmployee(NewEmployee employee) {
		persist(employee);
	}

	@SuppressWarnings("unchecked")
	public List<NewEmployee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(NewEmployee.class);
		return (List<NewEmployee>) criteria.list();
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from NewEmployee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	public NewEmployee findBySsn(String ssn) {
		Criteria criteria = getSession().createCriteria(NewEmployee.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (NewEmployee) criteria.uniqueResult();
	}

	public void updateEmployee(NewEmployee employee) {
		getSession().update(employee);
	}
}
