package com.example.spring.model;

import java.time.LocalDate;

public class Employee {

	private int id;

	private String name;

	private String assessmentDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAssessmentDate() {
		return assessmentDate;
	}

	public void setAssessmentDate(String string) {
		this.assessmentDate = string;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}