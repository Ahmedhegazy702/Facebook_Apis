package com.facebook.faceboo_apis.service;

import com.facebook.faceboo_apis.entity.User;
import com.facebook.faceboo_apis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }
}
