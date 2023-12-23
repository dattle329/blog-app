package com.vti.demorail79app.mapper;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.entity.Post;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.form.PostUpdateForm;

public class PostMapper {
    public static Post map(PostCreateForm form){
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        return post;
    }

    public static Post map(PostUpdateForm form){
        var post = new Post();
        post.setTitle(form.getTitle());
        post.setContent(form.getContent());
        post.setDescription(form.getDescription());
        return post;
    }
    public static PostDto map(Post post){
        var dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setUpdatedAt(post.getUpdatedAt());
        return dto.withSelfRel();
    }
}
