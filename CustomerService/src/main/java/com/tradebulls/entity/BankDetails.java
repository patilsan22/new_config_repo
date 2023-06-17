package com.tradebulls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankInfo")
public class BankDetails {
	@Id
	@Column
	private int bankId;
	
	@Column
	private String bankName;
	
	@Column
	private String ifscCode;
	
	@Column
	private String address;

	public BankDetails() {
		super();
	}

	public BankDetails(int bankId, String bankName, String ifscCode, String address) {
		super();
		this.bankId = bankId;
		this.bankName = bankName;
		this.ifscCode = ifscCode;
		this.address = address;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "BankDetails [bankId=" + bankId + ", bankName=" + bankName + ", ifscCode=" + ifscCode + ", address="
				+ address + "]";
	}
	
	
}
