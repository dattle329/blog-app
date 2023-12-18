package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.mapper.PostMapper;
import com.vti.demorail79app.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceimpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }
}
