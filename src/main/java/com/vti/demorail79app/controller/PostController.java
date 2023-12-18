package com.vti.demorail79app.controller;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody PostCreateForm form){
        return postService.create(form);
    }
}
