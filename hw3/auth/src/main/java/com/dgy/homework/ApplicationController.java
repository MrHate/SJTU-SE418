package com.dgy.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApplicationController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/login")
	public String login(){
		return "login.html";
	}

	@GetMapping("/ladder/{begin}&{end}")
	public @ResponseBody List<String> generateLadder(@PathVariable String begin, @PathVariable String end){
		return this.restTemplate.getForObject("http://ladder:8090/ladder/"+begin+"&"+end,List.class);
	}

	@GetMapping("/success")
	public @ResponseBody String loginsuccess(){
		return "success";
	}

}
