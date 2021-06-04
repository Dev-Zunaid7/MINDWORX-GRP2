package com.mindworx.alumnibackend.security;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Joiner;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.NumberRangeRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword arg0) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
           new LengthRule(8, 30), 
           new CharacterRule(EnglishCharacterData.UpperCase, 1), 
           new CharacterRule(EnglishCharacterData.Digit, 1), 
           new CharacterRule(EnglishCharacterData.Special, 1), 
           new NumberRangeRule(1, 5), 
           new CharacterRule(EnglishCharacterData.LowerCase, 1),
           new WhitespaceRule()));

        RuleResult result = validator.validate(new PasswordData(password));
        if (result.isValid()) {
            return true;
        }
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(
          Joiner.on(",").join(validator.getMessages(result)))
          .addConstraintViolation();
        return false;
    }
}
