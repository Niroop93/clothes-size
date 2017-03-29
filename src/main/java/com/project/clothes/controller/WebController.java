package com.project.clothes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.clothes.model.Brand;
import com.project.clothes.model.Jeans;
import com.project.clothes.repository.BrandRepository;
import com.project.clothes.repository.JeansRepository;


@RestController
public class WebController {
	@Autowired
	JeansRepository jeansRepo;
	@Autowired
	BrandRepository brandRepo;
	
	@RequestMapping("/")
    public String index() {
		System.out.println("hello");
        return "Greetings from Spring Boot!";
    }
	
	@RequestMapping("/saveBrands")
    public String saveBrand() {
		brandRepo.save(new Brand("GAP"));
		brandRepo.save(new Brand("American Eagle"));
		return "done";
	}
	
	@RequestMapping("/findAllBrands")
	public List<Brand> findAllBrands(){
		List<Brand> brands = (List<Brand>) brandRepo.findAll();
		return brands;
	}
	
	@RequestMapping("/findAllJeans")
	public List<Jeans> findAllJeans(){
		List<Jeans> Jean = (List<Jeans>) jeansRepo.findAll();
		return Jean;
	}
	
	@RequestMapping("/findOneJeans")
	public String findOneJeans(){
		Jeans Jean =  jeansRepo.findByWaist(28L);
		return Jean.toString();
	}
	
}
