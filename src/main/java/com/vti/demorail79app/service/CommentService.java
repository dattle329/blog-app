package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;

public interface CommentService {
    Commentdto create(CommentCreateForm form, Long postId);
}
