package com.facebook.faceboo_apis.repository;

import com.facebook.faceboo_apis.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
