package by.teachmeskills.mvc.service.user;

import by.teachmeskills.mvc.converter.IConverter;
import by.teachmeskills.mvc.entity.role.RoleEntity;
import by.teachmeskills.mvc.entity.role.RoleNameEnum;
import by.teachmeskills.mvc.entity.user.UserEntity;
import by.teachmeskills.mvc.model.auth.RegistrationModel;
import by.teachmeskills.mvc.model.user.UserModel;
import by.teachmeskills.mvc.repository.converter.password.PasswordAttributeConverter;
import by.teachmeskills.mvc.repository.role.RoleRepository;
import by.teachmeskills.mvc.repository.user.UserRepository;
import by.teachmeskills.mvc.service.AbstractService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AbstractService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private IConverter<UserModel, UserEntity> userConverter;

	public UserModel initAdmin(RegistrationModel registrationModel) {
		Optional<UserEntity> byLogin = userRepository.findByLogin(registrationModel.getLogin());
		byLogin.ifPresent(userEntity -> userRepository.delete(userEntity));

		return saveUser(registrationModel, RoleNameEnum.ADMIN);
	}

	public void saveUser(RegistrationModel registrationModel) {
		saveUser(registrationModel, RoleNameEnum.DEFAULT);
	}

    private UserModel saveUser(RegistrationModel registrationModel, RoleNameEnum roleNameEnum) {
        final UserModel userModel = new UserModel();
        userModel.setLogin(registrationModel.getLogin());
        userModel.setFirstName(registrationModel.getFirstName());
        userModel.setLastName(registrationModel.getLastName());
        final UserEntity userEntity = userConverter.convertToEntity(userModel);
        final Optional<RoleEntity> roleOptional = roleRepository.findByName(roleNameEnum);
        if (roleOptional.isPresent()) {
            userEntity.getRoles().add(roleOptional.get());
        }
        userEntity.setPassword(registrationModel.getPassword());
        final UserEntity savedUserEntity = userRepository.save(userEntity);
        return userConverter.convertToModel(savedUserEntity);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserConverter(
        IConverter<UserModel, UserEntity> userConverter) {
        this.userConverter = userConverter;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
