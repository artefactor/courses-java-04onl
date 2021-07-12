package by.teachmeskills.mvc.controller.product;

import by.teachmeskills.service.model.product.ProductModel;
import by.teachmeskills.service.ServiceException;
import by.teachmeskills.service.product.IProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    @ModelAttribute("products")
    public List<ProductModel> getProducts() {
        return productService.getAllProducts();
    }

    @ModelAttribute("product")
    public ProductModel product() {
        return new ProductModel();
    }

    @GetMapping
    public String products() {
        return "products";
    }

    @GetMapping("/{id}")
    public ModelAndView product(@PathVariable Long id) {
        return new ModelAndView("product-info", "product", productService.getProductById(id));
    }

    @PostMapping("/add")
    public ModelAndView createProduct(@ModelAttribute("product") ProductModel product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("product-add");
        }
        ProductModel createdProduct;
        try {
            createdProduct = productService.createProduct(product);
        } catch (ServiceException e) {
            return new ModelAndView("product-add", "message", e.getMessage());
        }
        return new ModelAndView("redirect:/products/" + createdProduct.getId(), "product", createdProduct);
    }

    @GetMapping("/add")
    public String getCreateProduct() {
        return "product-add";
    }

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
}
