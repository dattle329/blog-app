package com.vti.demorail79app.controller;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/v1/posts/{postId}/comments")
    public Commentdto create(@RequestBody CommentCreateForm form,@PathVariable("postId") Long postId){
        return commentService.create(form, postId);
    }
}
