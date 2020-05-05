package com.oc.webapp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.oc.webapp.model.dto.RegisteredUserDto;

/**
 * PasswordMatchesValidator
 */
public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        RegisteredUserDto user = (RegisteredUserDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }

}