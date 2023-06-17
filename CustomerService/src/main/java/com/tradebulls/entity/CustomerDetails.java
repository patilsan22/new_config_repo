package com.tradebulls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_info")
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
public class CustomerDetails {

	@Id
	@Column
	private String cust_ID;
	
	@Column
	private int bank_Id;
	
	@Column
	private String cust_name;

	@Column
	private String cust_city;

	@Column
	private int cust_status;

	public String getCust_ID() {
		return cust_ID;
	}

	public int getBank_Id() {
		return bank_Id;
	}

	public void setBank_Id(int bank_Id) {
		this.bank_Id = bank_Id;
	}

	public CustomerDetails() {

	}

	public CustomerDetails(String cust_ID, String cust_name, String cust_city, int cust_status, int bank_Id) {
		super();
		this.cust_ID = cust_ID;
		this.cust_name = cust_name;
		this.cust_city = cust_city;
		this.cust_status = cust_status;
		this.bank_Id = bank_Id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public String getCust_city() {
		return cust_city;
	}

	public void setCust_city(String cust_city) {
		this.cust_city = cust_city;
	}

	public int getCust_status() {
		return cust_status;
	}

	public void setCust_status(int cust_status) {
		this.cust_status = cust_status;
	}

	public void setCust_ID(String cust_ID) {
		this.cust_ID = cust_ID;
	}

	public CustomerDetails(String cust_name, String cust_city, int cust_status, int bank_Id) {
//		super();
//		this.cust_ID = cust_ID;
		this.cust_name = cust_name;
		this.cust_city = cust_city;
		this.cust_status = cust_status;
		this.bank_Id = bank_Id;
	}

	@Override
	public String toString() {
		return "Customer [cust_ID=" + cust_ID + ", bank_Id=" + bank_Id + ", cust_name=" + cust_name + ", cust_city="
				+ cust_city + ", cust_status=" + cust_status + "]";
	}

	
}
