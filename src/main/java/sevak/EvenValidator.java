package sevak.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenValidator implements ConstraintValidator<Even, Double> {

    @Override
    public void initialize(Even constraintAnnotation) {
    }

    @Override
    public boolean isValid(Double number, ConstraintValidatorContext ctx) {
        //if (Double.compare(number % 2d, 0d) == 0) {
        if (Double.compare(Math.IEEEremainder(number, 2), 0) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
