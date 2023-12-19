package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    Page<Commentdto> findAll(Pageable pageable);
    Commentdto create(CommentCreateForm form, Long postId);
}
