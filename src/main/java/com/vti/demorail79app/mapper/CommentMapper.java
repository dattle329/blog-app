package com.vti.demorail79app.mapper;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.entity.Comment;
import com.vti.demorail79app.form.CommentCreateForm;

public class CommentMapper {
    public static Comment map(CommentCreateForm form){
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setBody(form.getBody());
        comment.setEmail(form.getEmail());
        return comment;
    }

    public static Commentdto map(Comment comment){
        var dto = new Commentdto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setBody(comment.getBody());
        dto.setEmail(comment.getEmail());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedAt(comment.getUpdatedAt());
        return dto;
    }
}
