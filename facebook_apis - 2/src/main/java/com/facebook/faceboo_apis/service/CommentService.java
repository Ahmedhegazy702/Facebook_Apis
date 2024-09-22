package com.facebook.faceboo_apis.service;

import com.facebook.faceboo_apis.entity.Comment;
import com.facebook.faceboo_apis.entity.Post;
import com.facebook.faceboo_apis.entity.User;
import com.facebook.faceboo_apis.repository.CommentRepository;
import com.facebook.faceboo_apis.repository.PostRepsitory;
import com.facebook.faceboo_apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    PostRepsitory postRepsitory;

    @Autowired
    private UserRepository userRepository;

    public Comment createComment(String text,Long postId,Long userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("User not found"));

        Post post = postRepsitory.findById(postId).
                orElseThrow(() -> new RuntimeException("Post not found"));

        Comment comment = new Comment();
        comment.setText(text);
        comment.setUser(user);
        comment.setPost(post);
        return commentRepository.save(comment);
    }
}
