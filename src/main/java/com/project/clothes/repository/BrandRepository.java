package com.project.clothes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.clothes.model.Brand;
import com.project.clothes.model.Jeans;

@Repository("brandRepository")
public interface BrandRepository extends CrudRepository<Brand, Long>{
	Jeans findByName(String name);
}
