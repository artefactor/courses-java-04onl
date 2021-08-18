package by.tms.springmvctutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GreetingController {

	@Autowired
	UserRepository repository;

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		if (!repository.findByLogin(name).isPresent()){
			UserEntity s = new UserEntity();
			s.setLogin(name);
			repository.save(s);
		}

		Iterable<UserEntity> all = repository.findAll();
		List<UserEntity> list = new ArrayList<>();
		all.forEach(list::add);
		model.addAttribute("all", list);
		return "greeting";
	}

	@GetMapping("/greetingRest")
	@ResponseBody
	public Greeting greetingRest(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		Greeting greeting = new Greeting(name);
		return greeting;
	}


}