package com.sergei.HibernateJPA_persistanseXML;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mysql.fabric.xmlrpc.Client;

@Entity
@Table(name = "banks_table")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	
	@Column(name = "bank_name")
	private String name;
	@OneToMany(mappedBy = "bank")
	private List<Cliet> clients=new ArrayList<Cliet>();
	public Bank(int bid, String name, List<Cliet> clients) {
		super();
		this.bid = bid;
		this.name = name;
		this.clients = clients;
	}
	public Bank() {
		super();
	}
	public Bank(String name) {
		super();
		this.name = name;
	}
	public Bank(String name, List<Cliet> clients) {
		super();
		this.name = name;
		this.clients = clients;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Cliet> getClients() {
		return clients;
	}
	public void setClients(List<Cliet> clients) {
		this.clients = clients;
	}
	@Override
	public String toString() {
		return "Bank [bid=" + bid + ", name=" + name + ", clients=" + clients + "]";
	}
	
	
	
	
	

}
