package by.tms.spring.controller;

import by.tms.spring.model.Fruit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 TODO сделать по аналогии свой контроллер:
  1) список объектов
  2) добавление объекта ( по кнопке - на отдельной странице - потом переброс на список)
  3) редактирование ( по ссылке - на отдельной странице - потом переброс на список)
  4) удаление  (из списка)

 */
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
//        model.addAttribute("fruit", getO());
        return "fruit/list";
    }

    @ModelAttribute
	private Fruit fruit() {
		return new Fruit();
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
    public String add(@ModelAttribute Fruit fruit, Model model) {
        fruits.add(fruit.name);
        int size = fruits.size();
        int fruitId = size - 1;
        return "redirect:/fruits";
//        return "redirect:/fruits/" + fruitId;
    }

    @DeleteMapping ("/{id}")
    public String delete(@PathVariable("id") Integer fruitId) {
        //TODO hanlde error
        fruits.remove((int)fruitId);
        return "redirect:/fruits";
    }

    @ExceptionHandler(BindException.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("error", "AAAA, VSE PROPALO" + new Date());
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
