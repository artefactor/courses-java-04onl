package by.teachmeskills.mvc.service.auth;

import by.teachmeskills.mvc.entity.user.UserEntity;
import by.teachmeskills.mvc.model.auth.RegistrationModel;
import by.teachmeskills.mvc.repository.user.UserRepository;
import java.util.Optional;
import java.util.stream.Collectors;

import by.teachmeskills.mvc.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository userRepository;
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userOptional = userRepository.findByLogin(username);
        if (userOptional.isPresent()) {
            final UserEntity userEntity = userOptional.get();
            return User.builder()
                .username(username)
                .password(userEntity.getPassword())
                .roles(userEntity.getRoles().stream()
                    .map(r -> r.getName().name())
                    .collect(Collectors.toList())
                    .toArray(new String[] {})).build();
        }
        else {
            return autoregister(username);
        }
//        throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    private UserDetails autoregister(String username) {
        RegistrationModel newUser = RegistrationModel.fromLogin(username);
        userService.saveUser(newUser);
        return loadUserByUsername(username);
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
