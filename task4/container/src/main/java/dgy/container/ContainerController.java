package dgy.container;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContainerController {
	@Autowired
	private ContainerCore container;

	@GetMapping("/push")
	public String push(@RequestParam Object o){
		container.push(o);
		return "push";
	}

	@GetMapping("/pop")
	public Object pop(){
		return container.pop();
	}
}
