package com.vti.demorail79app.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Constraint(
        validatedBy = PostIdExistsValidator.class
)
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostIdExists {
    String message() default "The post doesn't exist.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
