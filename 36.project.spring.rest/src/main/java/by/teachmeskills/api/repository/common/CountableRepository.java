package by.teachmeskills.api.repository.common;

import org.springframework.data.jpa.repository.Query;

public interface CountableRepository {

    @Query("SELECT count(e) from #{#entityName} e")
    Integer getTotalCount();

}
