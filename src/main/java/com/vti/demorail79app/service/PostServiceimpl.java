package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.PostDto;
import com.vti.demorail79app.entity.Post;
import com.vti.demorail79app.form.PostCreateForm;
import com.vti.demorail79app.form.PostUpdateForm;
import com.vti.demorail79app.mapper.PostMapper;
import com.vti.demorail79app.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostServiceimpl implements PostService{

    private final PostRepository postRepository;

    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        return postRepository.findAll(pageable)
                .map(PostMapper::map);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public PostDto update(PostUpdateForm form, Long id) {
        var post = PostMapper.map(form);
        post.setId(id);
        var savedPost = postRepository.save(post);
        return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
