package com.dukedemo.microservices.client;


import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
@RestController
public class Client {
	
	@Inject
	private EurekaClient eurekaClient;
	
	@GetMapping("/jjjj")
	public String callDiscovery() {
		
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("service1", false);
		
		System.err.println(instanceInfo.getHomePageUrl());
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response
		  = restTemplate.getForEntity(instanceInfo.getHomePageUrl(), String.class);
		return response.getBody();
	}
	
	
}

