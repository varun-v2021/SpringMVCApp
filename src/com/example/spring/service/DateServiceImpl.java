package com.example.spring.service;

import java.util.Date;

import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Service;

@Service("dateService")
public class DateServiceImpl implements DateService {

	public String getNextAssessmentDate() {
		return new Date() + "";
	}

}
