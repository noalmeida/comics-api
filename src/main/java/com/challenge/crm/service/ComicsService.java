package com.challenge.crm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.challenge.crm.model.Comics;

@Service
public class ComicsService {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	public Comics getComics() {
		return restTemplate.getForObject("developer.marvel.com/v1/public/comics?ts=070720210259&apikey=bd00b34395e84e87a3099d69866399b9&hash=070720210259a85175d0f8b1c2c813e647b6a1ac708295dd63aebd00b34395e84e87a3099d69866399b9", Comics.class);
	}
	
	

	
}
