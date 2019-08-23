package com.sergei.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<Famely> famely;
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", famely=" + famely + "]";
	}
	public Set<Famely> getFamely() {
		return famely;
	}
	public void setFamely(Set<Famely> famely) {
		this.famely = famely;
	}
	public Role(String name) {
	
		this.name = name;
	}
	public Role() {
	
	}
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
	
	

}
