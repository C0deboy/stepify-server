package com.stepify.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Arrays;

public class DateFormatValidator implements ConstraintValidator<DateFormat, String> {
    private String[] formats;

    @Override
    public void initialize(DateFormat dateFormat) {
        formats = dateFormat.formats();
    }
 
    @Override
    public boolean isValid(String field, ConstraintValidatorContext cxt) {
        if (field == null) {
            return true;
        }
        return Arrays.stream(formats).anyMatch(format -> {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format).withResolverStyle(ResolverStyle.STRICT);
            try {
                dateTimeFormatter.parse(field);
                return true;
            } catch (Exception e) {
                return false;
            }
        });
    }
 
}