package com.tradebulls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "addressInfo")
public class AddressDetails {
	@Id
	@Column
	private int contactId;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private String country;
	@Column
	private long contactNumber;
	@Column
	private String corressAddress;
	@Column
	private String permAddress;
	@Column
	private String custId;

	public AddressDetails() {
		super();
	}

	public AddressDetails(int contactId, String city, String state, String country, long contactNumber,
			String corressAddress, String permAddress, String custId) {
		super();
		this.contactId = contactId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.contactNumber = contactNumber;
		this.corressAddress = corressAddress;
		this.permAddress = permAddress;
		this.custId = custId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCorressAddress() {
		return corressAddress;
	}

	public void setCorressAddress(String corressAddress) {
		this.corressAddress = corressAddress;
	}

	public String getPermAddress() {
		return permAddress;
	}

	public void setPermAddress(String permAddress) {
		this.permAddress = permAddress;
	}

}
