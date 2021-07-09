package by.teachmeskills.api.repository;

import by.teachmeskills.api.entity.IEntity;
import java.io.Serializable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface BaseRepository<E extends IEntity, ID extends Serializable> extends PagingAndSortingRepository<E, ID> {


}
