package com.facebook.faceboo_apis.Controller;

import com.facebook.faceboo_apis.entity.Comment;
import com.facebook.faceboo_apis.entity.Post;
import com.facebook.faceboo_apis.entity.User;
import com.facebook.faceboo_apis.service.CommentService;
import com.facebook.faceboo_apis.service.PostService;
import com.facebook.faceboo_apis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
public class FacebookController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestParam String message,@RequestParam Long userId){
        Post post = postService.createPost(message, userId);
        return ResponseEntity.ok(post);

    }
    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        return  ResponseEntity.ok(userService.save(user));

    }

    @PostMapping("/comment")
    public ResponseEntity<Comment> saveComment(@RequestParam String comment,@RequestParam Long postId
            ,@RequestParam Long userId){
        Comment comment1=commentService.createComment(comment,postId,userId);
        return ResponseEntity.ok(comment1);


    }
    @PostMapping("/{postId}/like")
    public ResponseEntity<String> likePost(@PathVariable Long postId){
        postService.likePost(postId);
        return ResponseEntity.ok("Liked post: "+ postId);

    }
    @GetMapping("/{postId}/likes")
    public ResponseEntity<String>getLikes(@PathVariable Long postId){
        int likesCount = postService.getLikes(postId);
        return ResponseEntity.ok("Number likes for post =" +likesCount);

    }
}
