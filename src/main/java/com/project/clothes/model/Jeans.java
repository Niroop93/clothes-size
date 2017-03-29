package com.project.clothes.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Jeans")
public class Jeans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "jeans_id")
	private Long jeans_id;
	
	@Column(name = "brand_id")
	@OneToMany
	private List<Brand> brand_id;
	
	@Column(name = "size")
	private Long size;
	
	@Column(name = "type")
	private Long type;
	
	@Column(name = "waist")
	private float waist;
	
	@Column(name = "hip")
	private float hip;

	public Long getJeans_id() {
		return jeans_id;
	}

	public void setJeans_id(Long jeans_id) {
		this.jeans_id = jeans_id;
	}

	public List<Brand> getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(List<Brand> brand_id) {
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

	public float getWaist() {
		return waist;
	}

	public void setWaist(float waist) {
		this.waist = waist;
	}

	public float getHip() {
		return hip;
	}

	public void setHip(float hip) {
		this.hip = hip;
	}

	@Override
	public String toString() {
		return "Jeans [brand_id=" + brand_id.get(0).getName() + ", size=" + size + "]";
	}

	/*@Override
	public String toString() {
		return "Jeans [jeans_id=" + jeans_id + ", brand_id=" + brand_id + ", size=" + size + ", type=" + type
				+ ", waist=" + waist + ", hip=" + hip + "]";
	}*/
	
	
}
