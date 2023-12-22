package com.vti.demorail79app.controller;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.entity.Post;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.form.PostFilterForm;
import com.vti.demorail79app.form.PostUpdateForm;
import com.vti.demorail79app.service.PostService;
import com.vti.demorail79app.validation.PostIdExists;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Validated
@RestController
@AllArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/api/v1/posts")
    public Page<PostDto> findAll(PostFilterForm form, Pageable pageable){
        return postService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/{id}")
    public Optional<Post> findById(@PathVariable("id") @PostIdExists Long id){
        return postService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public PostDto create(@RequestBody @Valid PostCreateForm form){
        return postService.create(form);
    }
    @PutMapping("/api/v1/posts/{id}")
    public PostDto update(@RequestBody @Valid PostUpdateForm form,@PathVariable("id") @PostIdExists Long id){
        return postService.update(form, id);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public void deleteById(@PathVariable("id") @PostIdExists Long id){
        postService.deleteById(id);
    }
}
