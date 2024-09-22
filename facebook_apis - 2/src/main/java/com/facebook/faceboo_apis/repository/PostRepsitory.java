package com.facebook.faceboo_apis.repository;

import com.facebook.faceboo_apis.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepsitory extends JpaRepository<Post, Long> {
}
