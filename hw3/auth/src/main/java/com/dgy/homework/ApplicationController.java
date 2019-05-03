package com.dgy.homework;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApplicationController {
	//@GetMapping("ladder")
	//public @ResponseBody String generateLadder(){
	//    return "ladder";
	//}

	@GetMapping("login")
	public String login(){
		return "login.html";
	}

	@GetMapping("success")
	public @ResponseBody String success(){
		return "success";
	}

}
