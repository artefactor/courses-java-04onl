package by.teachmeskills.api.repository.product;

import by.teachmeskills.api.entity.product.ProductEntity;
import by.teachmeskills.api.repository.BaseRepository;
import by.teachmeskills.api.repository.common.CountableRepository;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "newProducts", path = "newProducts")
public interface ProductRepository extends BaseRepository<ProductEntity, Long>, CountableRepository {

    List<ProductEntity> findAllByTitleOrDescription(String title, String description, Sort sort);

}
