package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.entity.Post;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.form.PostFilterForm;
import com.vti.demorail79app.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface PostService {
    Page<PostDto> findAll(PostFilterForm form, Pageable pageable);

    Optional<Post> findById(Long id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Long id);

    void deleteById(Long id);
}
