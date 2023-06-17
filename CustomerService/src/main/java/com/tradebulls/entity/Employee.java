package com.tradebulls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int emp_id;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empInfo")
	private EmpInfo empInfo;
	
	@Column
	private String name;

	@Column
	private String title;

	@Column
	private int salary;
	
	@Column
	private int pinCode;
	
	@Column
	private String city;

	public Employee() {
		super();
	}

	public Employee(int emp_id, String name, String title, int salary, int pinCode, String city) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.title = title;
		this.salary = salary;
		this.pinCode = pinCode;
		this.city = city;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", title=" + title + ", salary=" + salary
				+ ", pinCode=" + pinCode + ", city=" + city + "]";
	}
	
	



}