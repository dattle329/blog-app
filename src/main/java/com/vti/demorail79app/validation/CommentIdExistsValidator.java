package com.vti.demorail79app.validation;

import com.vti.demorail79app.repository.CommentRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintViolationException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentIdExistsValidator implements ConstraintValidator<CommentIdExists, Long> {
    private final CommentRepository commentRepository;

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return commentRepository.existsById(id);
    }
}
