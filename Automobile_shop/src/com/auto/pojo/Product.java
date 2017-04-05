package com.auto.pojo;

public class Product {
	int prd_id;
	int units_available;
	int units_sold;
	int units_total;
	String address;
	String prd_company;
	String prd_name;
	String prd_price;
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public int getUnits_available() {
		return units_available;
	}
	public void setUnits_available(int units_available) {
		this.units_available = units_available;
	}
	public int getUnits_sold() {
		return units_sold;
	}
	public void setUnits_sold(int units_sold) {
		this.units_sold = units_sold;
	}
	public int getUnits_total() {
		return units_total;
	}
	public void setUnits_total(int units_total) {
		this.units_total = units_total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrd_company() {
		return prd_company;
	}
	public void setPrd_company(String prd_company) {
		this.prd_company = prd_company;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	public String getPrd_price() {
		return prd_price;
	}
	public void setPrd_price(String prd_price) {
		this.prd_price = prd_price;
	}
	@Override
	public String toString() {
		return "Product [prd_id=" + prd_id + ", units_available=" + units_available + ", units_sold=" + units_sold
				+ ", units_total=" + units_total + ", address=" + address + ", prd_company=" + prd_company
				+ ", prd_name=" + prd_name + ", prd_price=" + prd_price + "]";
	}
	
	
	
}
