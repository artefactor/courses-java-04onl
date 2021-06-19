package by.tms.spring.controller;

import by.tms.spring.service.SampleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.tms.spring.model.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;

@Controller(value = "greeting")
@Api(value = "Greeting", description = "RESTful API example.")
public class GreetingController {

	private final SampleService service;

	public GreetingController(SampleService service) {
		this.service = service;
	}

	@ApiOperation(value = "Get greeting", notes = "Get greeting matching the given search string.", response = Greeting.class)
	@GetMapping("/greeting")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model,
			HttpServletRequest request
	) {
		model.addAttribute("name", name);
		String message = "I am presenting spring mvc";
		model.addAttribute("message", message);

		WebApplicationContext webApplicationContext = RequestContextUtils.findWebApplicationContext(request);
		int beanDefinitionCount = webApplicationContext.getBeanDefinitionCount();
		String[] beanDefinitionNames = webApplicationContext.getBeanDefinitionNames();
		model.addAttribute("beanDefinitionCount", beanDefinitionCount + " " + webApplicationContext);
		model.addAttribute("beanDefinitionNames", beanDefinitionNames);
		model.addAttribute("service", service.doService());
		model.addAttribute("beanDefinitionNamesRoot", service.list());

		return "greeting";
	}

	@GetMapping("/jquery")
	public String greetingJQuery(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		String message = "I am presenting spring mvc";
		model.addAttribute("message", message);
		return "jquery";
	}

}