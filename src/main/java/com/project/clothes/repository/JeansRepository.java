package com.project.clothes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.clothes.model.Jeans;



@Repository("jeansRepository")
public interface JeansRepository extends CrudRepository<Jeans, Long>{
	Jeans findByWaist(Long waist);
	
	@Query(value = "select b.brand_name,j.size"
			+ " from jeans j, brands b "
			+ "where j.brand_id=b.brand_id "
			+ "and (j.waist between ?4 and ?5) "
			+ "and (j.hip between ?2 and ?3)"
			+ "and j.brand_id=?1", nativeQuery = true)
	List<Object[]> findJeans(Long brandId,double hipsMin,double hipsMax,double waistMin,double waistMax);
	
	@Query(value = "Select j.waist from jeans j where j.brand_id = ?1 and j.size = ?2", nativeQuery = true)
	float findWaistbySize(Long brandId, Long size);
	
	@Query(value = "Select b.brand_name,j.size from jeans j left join brands b on j.brand_id=b.brand_id where j.brand_id=?1 and j.waist between ?2 and ?3", nativeQuery = true)
	List<Object[]> findJeansbyBrand(Long brandId,float waistMin,float waistMax);
	
}
