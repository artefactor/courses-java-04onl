package by.teachmeskills.service.product.impl;

import by.teachmeskills.persistence.dao.exception.DAOException;
import by.teachmeskills.persistence.dao.product.ProductDAO;
import by.teachmeskills.persistence.entity.product.ProductEntity;
import by.teachmeskills.service.exception.NotFoundException;
import by.teachmeskills.service.converter.IConverter;
import by.teachmeskills.service.model.product.ProductModel;
import by.teachmeskills.service.AbstractService;
import by.teachmeskills.service.ServiceException;
import by.teachmeskills.service.product.IProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService implements IProductService {

    private ProductDAO productDAO;
    private IConverter<ProductModel, ProductEntity> productConverter;

    @Override
    public List<ProductModel> getAllProducts() {
        return productConverter.convertAllToModels(productDAO.getAll());
    }

    @Override
    public ProductModel getProductById(Long id) {
        Optional<ProductEntity> entityOptional = productDAO.getEntity(id);
        return entityOptional
            .map(productEntity -> productConverter.convertToModel(productEntity))
            .orElseThrow(() -> new NotFoundException("Product with id: " + id + " not found"));
    }

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        ProductEntity createdEntity;
        try {
            createdEntity = productDAO.create(productConverter.convertToEntity(productModel));
        } catch (DAOException e) {
            throw new ServiceException("Unable to create product: " + e.getMessage(), e);
        }
        return productConverter.convertToModel(createdEntity);
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setProductConverter(IConverter<ProductModel, ProductEntity> productConverter) {
        this.productConverter = productConverter;
    }
}
