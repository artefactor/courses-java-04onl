package by.teachmeskills.mvc.repository.converter.password;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//@Component
//@Converter
//@Configurable
public class PasswordAttributeConverter implements AttributeConverter<String, String> {

    private final PasswordEncoder encoder;

    public PasswordAttributeConverter(@Lazy PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String convertToDatabaseColumn(String s) {
        return encoder.encode(s);
    }

    @Override
    public String convertToEntityAttribute(String s) {
        return s;
    }

}
