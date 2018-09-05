package com.example.demo.repository;

import com.example.demo.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postRepository")
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findByUserIdOrderByDateDesc(Integer userId);

    List<Post> findAllByOrderByDateDesc();
}
