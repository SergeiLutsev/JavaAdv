package com.sergei.Hiber_Test_HQL;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Laptop {

	@Id
	private int lid;
	private String brand;
	private double price;
	
	public Laptop(int lid, String brand, double price) {
		this.lid = lid;
		this.brand = brand;
		this.price = price;
	}
	public Laptop() {
		
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
	
}
