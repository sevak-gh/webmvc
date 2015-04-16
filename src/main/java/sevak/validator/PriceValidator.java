package sevak.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, Double> {

    @Override
    public void initialize(Price constraintAnnotation) {
    }

    @Override
    public boolean isValid(Double number, ConstraintValidatorContext ctx) {
        if ((number < 1) || (number > 10000)) {        
            return false;
        } else {
            return true;
        }
    }
}
