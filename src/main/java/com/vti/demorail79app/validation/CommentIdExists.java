package com.vti.demorail79app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(
        validatedBy = CommentIdExistsValidator.class
)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CommentIdExists {
    String message() default "The comment doesn't exist.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
