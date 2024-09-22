package com.facebook.faceboo_apis.repository;

import com.facebook.faceboo_apis.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
