package com.tradebulls.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeeInfo")
public class EmpInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String team;
	
	@Column
	private String manager;
	
	public EmpInfo() {
		super();
	}

	public EmpInfo(int id, String title, String team, String manager) {
		super();
		this.id = id;
		this.team = team;
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "EmpInfo [id=" + id + ", teamName=" + team + ", manager=" + manager + "]";
	}

}
