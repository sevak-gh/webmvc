package sevak.validator;

import sevak.domain.Product;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Product product = (Product) target;

        if (product.getDescription().startsWith("A")) {
            errors.rejectValue("description", "", "desc starts with A");
        }
    }
}
