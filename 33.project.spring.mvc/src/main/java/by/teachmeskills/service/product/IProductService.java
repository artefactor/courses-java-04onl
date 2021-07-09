package by.teachmeskills.service.product;

import by.teachmeskills.model.product.ProductModel;
import java.util.List;

public interface IProductService {

    List<ProductModel> getAllProducts();
    ProductModel getProductById(Long id);
    ProductModel createProduct(ProductModel productModel);

}
