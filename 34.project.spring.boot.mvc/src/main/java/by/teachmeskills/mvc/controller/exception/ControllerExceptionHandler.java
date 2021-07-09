package by.teachmeskills.mvc.controller.exception;

import by.teachmeskills.mvc.exception.NotFoundException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger;

    @ExceptionHandler(Throwable.class)
    public String handleGlobal(Model model, Throwable e) {
        logger.error("Unhandled error: {}", e.getMessage(), e);
        model.addAttribute("errorMessage", e.getMessage());
        return "error/error500";
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ModelAndView handleNotFound(Throwable e) {
        return new ModelAndView("error/error404", "errorMessage", e.getMessage());
    }

    @Autowired
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
}
