package com.project.clothes.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Holder;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.project.clothes.model.Brand;
//import com.project.clothes.model.InputData;
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
	public String getData() {

		return null;

	}

	private String findOneJeans(Long brandId, double hipsMin, double hipsMax, double waistMin, double waistMax) {

		List<Object[]> results = jeansRepo.findJeans(brandId, hipsMin, hipsMax, waistMin, waistMax);
		OutputData data = new OutputData();
		for (Object[] result : results) {
			data.setBrand((String) result[0]);
			data.setSize((String) result[1].toString());
		}
		Gson gson = new Gson();
		System.out.println(gson.toJson(data));
		return gson.toJson(data);
	}

	@RequestMapping("/findJeans")
	public String findJeansSize(@RequestBody String input) {
		System.out.println("in findJeansbyBrand");
		System.out.println(input);
		String results="";
		HashMap<String, String> holder = new HashMap();
		if (input != null && !input.isEmpty()) {
			String[] keyVals = input.split("&");
			for (String keyVal : keyVals) {
				String[] parts = keyVal.split("=", 2);
				holder.put(parts[0], parts[1]);
			}
			String gender = holder.get("gender");
			Long brandId1 = Long.parseLong(holder.get("brand"));
			Long size = Long.parseLong(holder.get("size"));
			// float hips = Float.valueOf(holder.get("style"));
			Long brandId2 = Long.parseLong(holder.get("brand2"));

			if (brandId1 != null && size != null && brandId2 != null) {
				float waist = jeansRepo.findWaistbySize(brandId1, size);
				float hips = jeansRepo.findHipbySize(brandId1, size);

				results = this.findOneJeans(brandId2, hips - 0.5f, hips + 0.5f, waist - 0.5f, waist + 0.5f);
				System.out.println(results);
			}
		}
		return  results;
	}
}
