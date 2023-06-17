package com.hibernate.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * @author Jeevan
 */
@Entity
@Table(name="policy")
public class Policy implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="policy_id")
	private String policyId;
	
	@Column(name="type")
	private String type;
	
	@Column(name="status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name="user_id", nullable=false)
	private User user;

	public Policy(){}

	public Policy(String policyId, String type, String status, User user) {
		super();
		this.policyId = policyId;
		this.type = type;
		this.status = status;
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", policyId=" + policyId + ", type=" + type + ", status=" + status + ", user="
				+ user + "]";
	}
	
}
