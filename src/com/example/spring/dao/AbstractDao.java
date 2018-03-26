package com.example.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {

	@Autowired
	//Autowired here from HibernateConfig.java file
	//This class serve as base class for database related operations.
	private SessionFactory sessionFactory;
	
	/*** IMPORTANT NOTE ***/
	//Notice above, that SessionFactory we have created earlier in HibernateConfig,
	//will be auto-wired here. This class serve as base class for database related operations.

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void persist(Object entity) {
		getSession().persist(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}
}