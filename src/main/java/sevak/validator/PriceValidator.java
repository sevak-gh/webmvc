package sevak.validator;

import java.math.BigDecimal;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, BigDecimal> {

    @Override
    public void initialize(Price constraintAnnotation) {
    }

    @Override
    public boolean isValid(BigDecimal number, ConstraintValidatorContext ctx) {
        if ((number.compareTo(BigDecimal.valueOf(1)) < 0) || (number.compareTo(BigDecimal.valueOf(10000)) > 0)) {        
            return false;
        } else {
            return true;
        }
    }
}
