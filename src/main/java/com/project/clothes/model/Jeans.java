package com.project.clothes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Jeans")
public class Jeans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jeans_id")
	private Long jeans_id;
	
	@Column(name = "brand_id")
	private Long brand_id;
	
	@Column(name = "size")
	private Long size;
	
	@Column(name = "type")
	private Long type;
	
	@Column(name = "waist")
	private Long waist;
	
	@Column(name = "length")
	private Long length;

	public Long getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getWaist() {
		return waist;
	}

	public void setWaist(Long waist) {
		this.waist = waist;
	}

	public Long getLength() {
		return length;
	}

	public void setLength(Long length) {
		this.length = length;
	}
	
	
	protected Jeans() {
	}

	public Jeans(Long brand_id, Long size, Long type, Long waist, Long length) {
		this.brand_id = brand_id;
		this.size = size;
		this.type = type;
		this.waist = waist;
		this.length = length;
	}

	@Override
	public String toString() {
		return "Jeans [brand_id=" + brand_id + ", size=" + size + ", type="
				+ type + ", waist=" + waist + ", length=" + length + "]";
	}
}
