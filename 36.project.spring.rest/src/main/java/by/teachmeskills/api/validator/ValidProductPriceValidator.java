package by.teachmeskills.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ValidProductPriceValidator implements ConstraintValidator<ValidProductPrice, Double> {

    private double min;

    @Value("${product.min.price}")
    private Double minPrice;

    @Override
    public void initialize(ValidProductPrice constraintAnnotation) {
        this.min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(Double aDouble, ConstraintValidatorContext constraintValidatorContext) {
        final boolean isValid = minPrice != null ? aDouble >= minPrice : aDouble >= min;
        return isValid;
    }
}
