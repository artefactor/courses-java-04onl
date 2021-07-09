package by.teachmeskills.api.service.product;

import by.teachmeskills.api.model.product.ProductModel;
import java.util.List;

public interface IProductService {

    List<ProductModel> getAllProducts();
    ProductModel getProductById(Long id);
    ProductModel createProduct(ProductModel productModel);
    ProductModel updateProduct(ProductModel productModel);
    void deleteProduct(Long id);
    Integer getTotalCount();

}
