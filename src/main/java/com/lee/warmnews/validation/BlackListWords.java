package com.lee.warmnews.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {BlackListWordsConstraintValidator.class}
)
public @interface BlackListWords {

    String message() default "Forbidden word found! Please don't use it.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
