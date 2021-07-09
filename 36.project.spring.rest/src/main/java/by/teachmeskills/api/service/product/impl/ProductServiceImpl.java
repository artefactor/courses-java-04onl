package by.teachmeskills.api.service.product.impl;

import by.teachmeskills.api.converter.IConverter;
import by.teachmeskills.api.dao.exception.DAOException;
import by.teachmeskills.api.dao.product.ProductDAO;
import by.teachmeskills.api.entity.product.ProductEntity;
import by.teachmeskills.api.exception.NotFoundException;
import by.teachmeskills.api.model.product.ProductModel;
import by.teachmeskills.api.repository.product.ProductRepository;
import by.teachmeskills.api.service.AbstractService;
import by.teachmeskills.api.service.ServiceException;
import by.teachmeskills.api.service.product.IProductService;
import java.util.List;
import java.util.Optional;
import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractService implements IProductService {

    private ProductDAO productDAO;
    private IConverter<ProductModel, ProductEntity> productConverter;
    private ProductRepository productRepository;

    @Override
    public List<ProductModel> getAllProducts() {
        return productConverter.convertAllToModels(Lists
            .newArrayList(productRepository.findAll()));
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

    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        return productConverter.convertToModel(productDAO.updateEntity(productConverter.convertToEntity(productModel)));
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteEntity(id);
    }

    @Override
    public Integer getTotalCount() {
        return productRepository.getTotalCount();
    }

    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Autowired
    public void setProductConverter(IConverter<ProductModel, ProductEntity> productConverter) {
        this.productConverter = productConverter;
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
