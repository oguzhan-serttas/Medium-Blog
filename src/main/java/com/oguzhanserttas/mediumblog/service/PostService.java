package com.oguzhanserttas.mediumblog.service;

import com.oguzhanserttas.mediumblog.model.Post;

import java.util.List;

public interface PostService {


    //upsert insert or update
    Post save(Post post);

    void delete(Long id);

    Post findById(Long id);

    List<Post> findAll();
}
