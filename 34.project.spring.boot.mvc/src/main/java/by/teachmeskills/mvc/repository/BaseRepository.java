package by.teachmeskills.mvc.repository;

import by.teachmeskills.mvc.entity.IEntity;
import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<E extends IEntity, ID extends Serializable> extends PagingAndSortingRepository<E, ID> {

}
