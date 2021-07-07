package com.challenge.crm.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.crm.model.Comics;
import com.challenge.crm.service.ComicsService;


@RestController
@RequestMapping("/comics")
public class ComicsController {
	
	ComicsService comicsService;
	
	@GetMapping
	public Comics getComics() {
		return comicsService.getComics();
	}
		  
	

}
