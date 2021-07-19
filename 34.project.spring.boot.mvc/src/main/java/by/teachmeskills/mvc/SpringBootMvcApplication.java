package by.teachmeskills.mvc;

import by.teachmeskills.mvc.entity.role.RoleEntity;
import by.teachmeskills.mvc.entity.role.RoleNameEnum;
import by.teachmeskills.mvc.model.auth.RegistrationModel;
import by.teachmeskills.mvc.model.user.UserModel;
import by.teachmeskills.mvc.repository.role.RoleRepository;
import by.teachmeskills.mvc.service.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
// это не работает, но как пример что можно эксклудить
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringBootMvcApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootMvcApplication.class, args);
		initDatabase(context);
	}

	// TODO make in one transaction
	private static void initDatabase(ConfigurableApplicationContext context) {
		RoleRepository repository = context.getBean(RoleRepository.class);
		saveIfNotPresent(repository, RoleNameEnum.ADMIN);
		saveIfNotPresent(repository, RoleNameEnum.DEFAULT);

		RegistrationModel defaultAdmin = RegistrationModel.fromLogin("admin");
		UserModel userModel = context.getBean(UserService.class).initAdmin(defaultAdmin);  // <-- here
		System.out.println("admin is created/update " + userModel);
	}

	private static void saveIfNotPresent(RoleRepository repository, RoleNameEnum roleNameEnum) {
		if (!repository.findByName(roleNameEnum).isPresent()){
			RoleEntity ent = buildRoleEntity(roleNameEnum);
			repository.save(ent);
		}
	}

	private static RoleEntity buildRoleEntity(RoleNameEnum name) {
		RoleEntity ent = new RoleEntity();
		ent.setName(name);
		return ent;
	}

}
