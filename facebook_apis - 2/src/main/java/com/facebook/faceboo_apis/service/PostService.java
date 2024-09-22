package com.facebook.faceboo_apis.service;

import com.facebook.faceboo_apis.entity.Post;
import com.facebook.faceboo_apis.entity.User;
import com.facebook.faceboo_apis.repository.PostRepsitory;
import com.facebook.faceboo_apis.repository.UserRepository;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepsitory postRepsitory;

    @Autowired
    private UserRepository userRepository;

    public Post createPost(String message,Long userId) {

        User user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        Post post = new Post();
        post.setMessage(message);
        post.setUser(user);
        post.setLikes(0);
        return postRepsitory.save(post);
    }

    public void likePost(Long postId) {
        Post post = postRepsitory.findById(postId).
                orElseThrow(()->new RuntimeException("Post not found"));

        post.setLikes(post.getLikes() + 1); // Increment likes
        postRepsitory.save(post);
    }

    public int getLikes(Long postId) {
        Post post = postRepsitory.findById(postId).
                orElseThrow(()->new RuntimeException("Post not found"));
        return post.getLikes();
    }
}
