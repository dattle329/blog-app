package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.mapper.CommentMapper;
import com.vti.demorail79app.repository.CommentRepository;
import com.vti.demorail79app.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService{
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Page<Commentdto> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable)
                .map(CommentMapper::map);
    }

    @Override
    public Commentdto create(CommentCreateForm form, Long postId) {
        var comment = CommentMapper.map(form);
        var post = postRepository.findById(postId).get();
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }
}