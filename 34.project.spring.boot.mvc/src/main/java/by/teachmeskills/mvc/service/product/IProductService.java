package by.teachmeskills.mvc.service.product;

import by.teachmeskills.mvc.model.product.ProductModel;
import java.util.List;

public interface IProductService {

    List<ProductModel> getAllProducts();
    ProductModel getProductById(Long id);
    ProductModel createProduct(ProductModel productModel);

}
