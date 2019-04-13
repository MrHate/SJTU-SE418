package com.dgy.homework;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping(value="/ladder")
public class LadderController{

	@RequestMapping(value="/{s1}&{s2}",method=RequestMethod.GET,produces="application/json")
	public List<String> getLadder(@PathVariable String s1,@PathVariable String s2){
		return Ladder.run(s1,s2);
	}
}
