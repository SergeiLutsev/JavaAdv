package com.sergei.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "famelys")
public class Famely {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@ManyToOne(fetch = FetchType.LAZY)
	private Role role;
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "famely")
	private List<WishList> wishLists;
	
	public List<WishList> getWishLists() {
		return wishLists;
	}
	public void setWishLists(List<WishList> wishLists) {
		this.wishLists = wishLists;
	}
	public Famely(String name, Role role) {
		this.name = name;
		this.role = role;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Famely() {
		
	}
	@Override
	public String toString() {
		return "Famely [id=" + id + ", name=" + name + ", role=" + role + "]";
	}
	
	

}
