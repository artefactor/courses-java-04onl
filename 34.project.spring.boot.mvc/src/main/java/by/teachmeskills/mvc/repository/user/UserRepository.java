package by.teachmeskills.mvc.repository.user;

import by.teachmeskills.mvc.entity.user.UserEntity;
import by.teachmeskills.mvc.repository.BaseRepository;
import java.util.Optional;

public interface UserRepository extends BaseRepository<UserEntity, Long> {

    Optional<UserEntity> findByLogin(String login);
}
