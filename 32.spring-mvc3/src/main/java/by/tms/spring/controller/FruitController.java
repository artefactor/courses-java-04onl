package by.tms.spring.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.tms.spring.model.Fruit;

/**
 *
 */
@Controller ("fruit")
@RequestMapping("/fruits")
public class FruitController {

    List<String> fruits = new ArrayList<>();

    public FruitController() {
        initFruits();
    }

    void initFruits() {
        fruits.add("apple");
        fruits.add("lemon");
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("fruits", fruits);
        return "fruit/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable ("id") Integer id, Model model) {
        //TODO handle if not exist
        String fruit = fruits.get(id);
        model.addAttribute("fruit", fruit);
        model.addAttribute("fruitlist", "fruits");
        model.addAttribute("fruitlistmvc", "mvyyyyc/fruits");
        return "fruit/detail";
    }

    @PostMapping
    public String add(Fruit fruit, Model model) {
        fruits.add(fruit.name);
        int size = fruits.size();
        int fruitId = size - 1;
        return "redirect:/fruits/" + fruitId;
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Integer fruitId) {
        //TODO hanlde error
        fruits.remove((int)fruitId);
        return "redirect:/fruits/";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", "AAAA, VSE PROPALO" + new Date());
        return ClassUtils.getShortName(e.getClass());
    }
}
