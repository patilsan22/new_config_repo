package com.hibernate.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
/**
 * @author Jeevan
 */
@Entity
@Table(name = "nominee")
public class Nominee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "nominee_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToMany(targetEntity = User.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "User_Nominee", 
				joinColumns = { @JoinColumn(name = "nominee_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "user_id") })
	private Set<User> user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Nominee [id=" + id + ", name=" + name + ", user=" + user + "]";
	}
}
