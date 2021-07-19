package by.teachmeskills.mvc.entity.user;

import by.teachmeskills.mvc.entity.AbstractEntity;
import by.teachmeskills.mvc.entity.role.RoleEntity;
import by.teachmeskills.mvc.repository.converter.password.PasswordAttributeConverter;
//import by.teachmeskills.mvc.repository.converter.password.PasswordAttributeConverter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserEntity extends AbstractEntity {

    @Size(min = 4, max = 36)
    private String login;

    @Size(min = 4, max = 60)
    // здесь будет не спринг контекст, а создастся новый конвертер
    @Convert(converter = PasswordAttributeConverter.class)
    private String password;

    //LocalDate-относительно_новый_класс_в_java.Когда_он_появился,в_тех__версиях
    //хибернейта__не-было_его_поддержки_и_надо_было_добавлять_конвертор_для_поля
    @Column(name = "created_on")
    @NotNull
    private LocalDate createdOn;

    //связь_только_в_одну_сторону,для_роли_список_юзеров_не_нужен
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id_fk"), inverseJoinColumns = @JoinColumn(name = "role_id_fk"))
    private Set<RoleEntity> roles = new HashSet<>();

    //аннотация_приперсист
    @Override
    @PrePersist
    public void init() {
        super.init();
        this.createdOn = LocalDate.now();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}
