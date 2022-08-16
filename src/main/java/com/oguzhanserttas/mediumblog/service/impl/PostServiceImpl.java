package com.oguzhanserttas.mediumblog.service.impl;

import com.oguzhanserttas.mediumblog.excepton.ResourceNotFoundException;
import com.oguzhanserttas.mediumblog.model.Post;
import com.oguzhanserttas.mediumblog.repository.PostRepository;
import com.oguzhanserttas.mediumblog.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    //TODO : when create a new post then sen your own medium account.
    @Override
    public Post save(Post post) {

        if (post.getId() == null) {
            post.setCreatedAt(LocalDateTime.now());
        } else {
            post.setCreatedAt(findById(post.getId()).getCreatedAt());
            post.setUpdatedAt(LocalDateTime.now());
        }
        return postRepository.save(post);
    }


    @Override
    public void delete(Long id) {
        postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
        postRepository.deleteById(id);
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }


}
