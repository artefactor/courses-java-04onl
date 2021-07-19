package by.teachmeskills.api.controller.product;

import by.teachmeskills.api.model.product.ProductModel;
import by.teachmeskills.api.service.product.IProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.validation.Valid;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private IProductService productService;

    @PostMapping
    @Operation(summary = "Create new product", description = "Create new product"
            // not needed now
//            ,security = @SecurityRequirement(name = "basicAuth")
    )
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductModel> createProduct(
        @Parameter(name = "product model", required = true, description = "Product to created") @Valid @RequestBody ProductModel productModel) throws URISyntaxException {
        final ProductModel product = productService.createProduct(productModel);
        final String uri = "/products/" + product.getId();
        return ResponseEntity.created(new URI(uri)).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProductModel>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
            .header("X-Total-Count", productService.getTotalCount().toString())
            .body(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> updateProduct(@RequestBody ProductModel productModel, @PathVariable Long id) {
        return ResponseEntity.ok(productService.updateProduct(productModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
}
