package com.project.clothes.model;

import java.io.Serializable;

public class OutputData implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3427030990950619116L;
	
	String brand;
	String size;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "OutputData [brand=" + brand + ", size=" + size + "]";
	}
	
	

}
