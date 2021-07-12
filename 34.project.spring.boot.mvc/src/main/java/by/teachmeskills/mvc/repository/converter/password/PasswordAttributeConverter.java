//package by.teachmeskills.mvc.repository.converter.password;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
//@Converter
//@Component
//public class PasswordAttributeConverter implements AttributeConverter<String, String> {
//
//    private PasswordEncoder encoder;
//
//    @Override
//    public String convertToDatabaseColumn(String s) {
//        return encoder.encode(s);
//    }
//
//    @Override
//    public String convertToEntityAttribute(String s) {
//        return s;
//    }
//
//    @Autowired
//    public void setEncoder(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }
//}
