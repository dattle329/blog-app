package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.form.PostCreateForm;

import java.util.List;

public interface PostService {
    PostDto create(PostCreateForm form);

}
