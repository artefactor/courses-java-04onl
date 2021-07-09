package by.teachmeskills.mvc.repository.role;

import by.teachmeskills.mvc.entity.role.RoleEntity;
import by.teachmeskills.mvc.entity.role.RoleNameEnum;
import by.teachmeskills.mvc.repository.BaseRepository;
import java.util.Optional;

public interface RoleRepository extends BaseRepository<RoleEntity, Long> {

    Optional<RoleEntity> findByName(RoleNameEnum name);
}
