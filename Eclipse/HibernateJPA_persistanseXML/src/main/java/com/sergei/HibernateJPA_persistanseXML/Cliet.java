package com.sergei.HibernateJPA_persistanseXML;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients_table")
public class Cliet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	
	private String name;
	@ManyToOne
	private Bank bank;
	public Cliet(int cid, String name, Bank bank) {
		this.cid = cid;
		this.name = name;
		this.bank = bank;
	}
	public Cliet(String name, Bank bank) {
		this.name = name;
		this.bank = bank;
	}
	public Cliet(String name) {
		this.name = name;
	}
	
	public Cliet() {}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	@Override
	public String toString() {
		return "Cliet [cid=" + cid + ", name=" + name + ", bank=" + bank + "]";
	}
	
	
	
	
}
