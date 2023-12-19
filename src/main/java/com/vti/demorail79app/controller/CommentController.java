package com.vti.demorail79app.controller;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/api/v1/comments")
    public Page<Commentdto> findAll(Pageable pageable){
        return commentService.findAll(pageable);
    }

    @PostMapping("/api/v1/posts/{postId}/comments")
    public Commentdto create(@RequestBody CommentCreateForm form,@PathVariable("postId") Long postId){
        return commentService.create(form, postId);
    }
}
