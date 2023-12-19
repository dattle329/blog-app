package com.vti.demorail79app.repository;

import com.vti.demorail79app.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
