package com.vti.demorail79app.validation;

import com.vti.demorail79app.repository.PostRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostTitleNotExistsValidator implements ConstraintValidator<PostTitleNotExists, String> {
    private final PostRepository postRepository;
    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        return !postRepository.existsByTitle(title);
    }
}
