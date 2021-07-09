package by.teachmeskills.mvc.controller.shoppingcart;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    @GetMapping
    public String shoppingCart() {
        return "shopping-cart/shopping-cart";
    }

}
