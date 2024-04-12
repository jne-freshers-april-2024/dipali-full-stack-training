package com.spring.restfulwebservices.jpa;

import com.spring.restfulwebservices.user.Post;
import com.spring.restfulwebservices.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
