package com.project.clothes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.clothes.model.Jeans;



@Repository("jeansRepository")
public interface JeansRepository extends CrudRepository<Jeans, Long>{
	Jeans findByWaist(Long waist);
}
