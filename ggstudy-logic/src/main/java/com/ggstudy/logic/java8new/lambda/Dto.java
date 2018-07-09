package com.ggstudy.logic.java8new.lambda;

import java.util.Date;

public class Dto {
	String name;
	Date date;
	int status;

	public Dto(String name, Date date, int status) {
		this.name = name;
		this.date = date;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
