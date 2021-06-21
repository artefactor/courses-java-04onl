package by.tms.spring.controller;

import by.tms.spring.model.Greeting;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
//@Api(value = "GreetingRest", description = "RESTful API example.")
public class GreetingControllerRest {

    private static final String template = "Hello, rest %s!";
    private final AtomicLong counter = new AtomicLong();

//    @ApiOperation(value = "Get greeting Rest", notes = "Get greeting matching the given search string.",  response = Greeting.class)
   // @GET
    @RequestMapping("/greetingrest")
    @ResponseBody
    public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}