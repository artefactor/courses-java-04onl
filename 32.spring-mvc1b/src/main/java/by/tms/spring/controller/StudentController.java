package by.tms.spring.controller;

import by.tms.spring.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute Student student, BindingResult errors, Model model) {
		model.addAttribute("stud", student);
		return "student";
	}

	@RequestMapping(value = "/stud", method = RequestMethod.GET)
	public String saveStudent(Model model) {
		return "student";
	}
}
