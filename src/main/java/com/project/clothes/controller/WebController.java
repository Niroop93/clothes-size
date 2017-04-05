package com.project.clothes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.project.clothes.model.Brand;
import com.project.clothes.model.Jeans;
import com.project.clothes.model.OutputData;
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
	public List<Brand> findAllBrands() {
		List<Brand> brands = (List<Brand>) brandRepo.findAll();
		return brands;
	}

	@RequestMapping("/findAllJeans")
	public List<Jeans> findAllJeans() {
		List<Jeans> Jean = (List<Jeans>) jeansRepo.findAll();
		return Jean;
	}
	
	@RequestMapping("/getData")
	public String getData()
	{
		
		
		return null;
		
	}
	
	private String findOneJeans(Long brandId,double hipsMin,double hipsMax,double waistMin,double waistMax) {
		
		List<Object[]> results = jeansRepo.findJeans(brandId,hipsMin , hipsMax, waistMin, waistMax);
		OutputData data = new OutputData();
		for (Object[] result : results) {
			data.setBrand((String)result[0]);
			data.setSize((String)result[1].toString());
		}
		Gson gson = new Gson();
		//System.out.println(gson.toJson(data));
		return gson.toJson(data);
	}
}
