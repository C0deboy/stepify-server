package com.placeholder.threelevels.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = DateFormatValidator.class)
@Target( { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFormat {
    String message() default "Invalid date format";
    String[] formats();
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}