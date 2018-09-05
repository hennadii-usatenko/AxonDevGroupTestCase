package com.example.demo.service;

import com.example.demo.model.Post;

import java.util.List;

/**
 * @author Gennadiy Usatenko
 * @version 03.09.2018
 */
public interface PostService {

    void savePost(Post post);

    List<Post> getAllPosts();

    List<Post> getByUserId(Integer userId);

    Post getById(Integer postId);

    void deletePostById(Integer postId);

}
