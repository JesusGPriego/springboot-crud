package com.suleware.springboot.app.springboot_crud.validations;

import org.springframework.stereotype.Component;

import com.suleware.springboot.app.springboot_crud.services.ProductService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Component
public class IsExistsDBValidation implements ConstraintValidator<IsExistDB, String> {

    private ProductService pService;

    public IsExistsDBValidation(ProductService pService) {
        this.pService = pService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !pService.existsBySku(value);

    }

}
