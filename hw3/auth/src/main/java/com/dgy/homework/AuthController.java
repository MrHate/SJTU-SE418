package com.dgy.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AuthController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/ladder/{begin}&{end}")
	public List<String> generateLadder(@PathVariable String begin, @PathVariable String end){
		return this.restTemplate.getForObject("http://ladder:8090/ladder/"+begin+"&"+end,List.class);
	}

	@GetMapping("/")
	public String loginsuccess(){
		return "Login success!\nSend GET request to \"/ladder/{begin}&{end}\" to generate word ladder from ladder microservice.";
	}

}
