package com.project.clothes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "brand_id")
		private Long brand_id;
		
		@Column(name = "brand_name")
		private String name;

		public Long getBrand_id() {
			return brand_id;
		}

		public void setBrand_id(Long brand_id) {
			this.brand_id = brand_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		protected Brand() {
		}

		public Brand(String name) {
			this.name = name;
		}
		
		@Override
		public String toString() {
			return "Brand [name=" + name + "]";
		}
}
