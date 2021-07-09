package by.teachmeskills.mvc.entity.role;

import by.teachmeskills.mvc.entity.AbstractEntity;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "roles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RoleEntity extends AbstractEntity {

    @NotNull
    private RoleNameEnum name;

    public RoleNameEnum getName() {
        return name;
    }

    public void setName(RoleNameEnum name) {
        this.name = name;
    }
}
