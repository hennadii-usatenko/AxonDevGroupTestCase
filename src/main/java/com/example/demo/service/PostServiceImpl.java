package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.repository.PostRepository;
import com.example.demo.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service("postService")
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    private FileSystemStorageService fileSystemStorageService;

    @Override
    public void savePost(Post post){
        if(post.getPhoto() != null && !post.getPhoto().getOriginalFilename().isEmpty()){
            fileSystemStorageService.store(post.getPhoto());
            post.setPhotoFileName( post.getPhoto().getOriginalFilename() );
        }
        post.setDate(new Date());
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllByOrderByDateDesc();
    }

    @Override
    public List<Post> getByUserId(Integer userId) {
        return postRepository.findByUserIdOrderByDateDesc(userId);
    }

    @Override
    public Post getById(Integer postId) {
        return postRepository.findById(postId).get();
    }

    @Override
    public void deletePostById(Integer postId) {
        postRepository.deleteById(postId);
    }
}
