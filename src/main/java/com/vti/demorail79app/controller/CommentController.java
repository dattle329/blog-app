package com.vti.demorail79app.controller;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.form.CommentFilterForm;
import com.vti.demorail79app.form.CommentUpdateForm;
import com.vti.demorail79app.service.CommentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<Commentdto> findAll(CommentFilterForm form, Pageable pageable){
        return commentService.findAll(form, pageable);
    }

    @GetMapping("/api/v1/posts/{postId}/comments")
    public Page<Commentdto> findByPostId(@PathVariable("postId") Long postId, Pageable pageable){
        return commentService.findByPostId(postId, pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public Commentdto create(@RequestBody @Valid CommentCreateForm form, @PathVariable("postId") Long postId){
        return commentService.create(form, postId);
    }

    @PutMapping("/api/v1/comments/{id}")
    public Commentdto update(@RequestBody @Valid CommentUpdateForm form, @PathVariable("id") Long id){
        return commentService.update(form, id);
    }

    @DeleteMapping("/api/v1/comments/{id}")
    public void deleteById(@PathVariable("id") Long id){
        commentService.deleteById(id);
    }

    @DeleteMapping("/api/v1/comments/email/{email}")
    public void deleteByEmail(@PathVariable("email") String email){
        commentService.deleteByEmail(email);
    }
}
