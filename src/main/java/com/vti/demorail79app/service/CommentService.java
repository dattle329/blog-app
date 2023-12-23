package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.form.CommentFilterForm;
import com.vti.demorail79app.form.CommentUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Commentdto> findAll(CommentFilterForm form, Pageable pageable);

    Page<Commentdto> findByPostId(Long postId, Pageable pageable);

    Commentdto findById(Long id);
    Commentdto create(CommentCreateForm form, Long postId);

    Commentdto update(CommentUpdateForm form, Long id);

    void deleteById(Long id);

    void deleteByEmail(String email);

}
