package com.rest.template.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.template.dto.User;

@RestController
public class ProfileController {

	@Autowired
	private RestTemplate temp;
	
	
	//exchange() demo
	@GetMapping("/exchangeDemo/{id}")
	public void getUserDetails(@PathVariable("id") Integer id) {
		String url = "http://localhost:8881/user/"+id;
		//set header value
		HttpHeaders headers = new HttpHeaders();
		//set contentType
		headers.setContentType(MediaType.APPLICATION_JSON);
		//set accept type
		List<MediaType> ll = new ArrayList<>();
		ll.add(MediaType.APPLICATION_XML);
		ll.add(MediaType.APPLICATION_JSON);
		headers.setAccept(ll);
		HttpEntity<HttpHeaders> httpEntity = new HttpEntity<HttpHeaders>(headers);
		
		//use when you know the pojo type
		ResponseEntity<User> resp1 =  temp.exchange(url, HttpMethod.GET, httpEntity, User.class);
		
		//OR
		//use when dont know pojo(responce of api) type
		ResponseEntity<String> resp2 =  temp.exchange(url, HttpMethod.GET, httpEntity, String.class);
		
		User body1 = resp1.getBody();
		System.out.println("body1 : "+body1);
		String body2 = resp2.getBody();
		System.out.println("body2 : "+body2);
	}
}
