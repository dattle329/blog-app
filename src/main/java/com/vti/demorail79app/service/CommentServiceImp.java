package com.vti.demorail79app.service;

import com.vti.demorail79app.dto.Commentdto;
import com.vti.demorail79app.entity.Comment;
import com.vti.demorail79app.form.CommentCreateForm;
import com.vti.demorail79app.form.CommentFilterForm;
import com.vti.demorail79app.form.CommentUpdateForm;
import com.vti.demorail79app.mapper.CommentMapper;
import com.vti.demorail79app.repository.CommentRepository;
import com.vti.demorail79app.repository.PostRepository;
import com.vti.demorail79app.specification.CommentSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService{
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public Page<Commentdto> findAll(CommentFilterForm form, Pageable pageable) {
        var spec = CommentSpecification.buildSpec(form);
        return commentRepository.findAll(spec, pageable)
                .map(CommentMapper::map);
    }

    @Override
    public Page<Commentdto> findByPostId(Long postId, Pageable pageable) {
        return commentRepository.findByPostId(postId, pageable)
                .map(CommentMapper::map);
    }

    @Override
    public Commentdto findById(Long id) {
        var comment = commentRepository.findById(id).get();
        return CommentMapper.map(comment);
    }

    @Override
    public Commentdto create(CommentCreateForm form, Long postId) {
        var comment = CommentMapper.map(form);
        var post = postRepository.findById(postId).get();
        comment.setPost(post);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public Commentdto update(CommentUpdateForm form, Long id) {
        var comment = commentRepository.findById(id).get();
        CommentMapper.map(form, comment);
        var savedComment = commentRepository.save(comment);
        return CommentMapper.map(savedComment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByEmail(String email) {
        commentRepository.deleteByEmail(email);
    }

}
