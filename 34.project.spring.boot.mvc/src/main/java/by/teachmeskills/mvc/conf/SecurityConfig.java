package by.teachmeskills.mvc.conf;

import by.teachmeskills.mvc.entity.role.RoleNameEnum;
import by.teachmeskills.mvc.service.auth.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private AuthService authService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
//            .antMatchers("/products/add").hasRole(RoleNameEnum.ADMIN.name())
            .antMatchers("/products").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/doLogin")
            .loginPage("/login").permitAll()
            .usernameParameter("login")
            .passwordParameter("pass")
            .failureUrl("/login?error")
            .defaultSuccessUrl("/products")
            .and()
            .logout()
            .logoutSuccessUrl("/products");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }
}
