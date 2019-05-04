package dgy.ladder;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/ladder")
public class LadderController{

	@GetMapping(value="/{s1}&{s2}",produces="application/json")
	public List<String> getLadder(@PathVariable String s1,@PathVariable String s2){
		return Ladder.run(s1,s2);
	}
}
