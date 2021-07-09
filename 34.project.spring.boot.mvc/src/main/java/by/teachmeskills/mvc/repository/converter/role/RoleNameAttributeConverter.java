package by.teachmeskills.mvc.repository.converter.role;

import by.teachmeskills.mvc.entity.role.RoleNameEnum;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class RoleNameAttributeConverter implements AttributeConverter<RoleNameEnum, String> {

    @Override
    public String convertToDatabaseColumn(RoleNameEnum roleNameEnum) {
        return roleNameEnum.name();
    }

    @Override
    public RoleNameEnum convertToEntityAttribute(String s) {
        return RoleNameEnum.valueOf(s);
    }
}
