package by.teachmeskills.mvc.controller.exception;

import by.teachmeskills.service.exception.NotFoundException;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

	final Logger logger;

	public ControllerExceptionHandler(Logger logger) {
		this.logger = logger;
	}

	@ExceptionHandler(Throwable.class)
	public String handleGlobal(Model model, Throwable e) {
		model.addAttribute("message", e.getMessage());
		return "error500";
	}

	@ExceptionHandler(NotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ModelAndView handleNotFound(Throwable e) {
		return new ModelAndView("error404", "message", e.getMessage());
	}

}
