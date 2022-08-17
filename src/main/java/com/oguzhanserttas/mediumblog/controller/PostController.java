package com.oguzhanserttas.mediumblog.controller;

import com.oguzhanserttas.mediumblog.model.Post;
import com.oguzhanserttas.mediumblog.service.PostIntegration;
import com.oguzhanserttas.mediumblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final PostIntegration postIntegration;

    public PostController(PostService postService, PostIntegration postIntegration) {
        this.postService = postService;
        this.postIntegration = postIntegration;
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        postIntegration.sendPost(post);
        return new ResponseEntity<>(postService.save(post), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getById(@PathVariable(name = "id") long id) {
        return new ResponseEntity<>(postService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.findAll();
    }

    @PutMapping("{id}")
    public ResponseEntity<Post> update(@PathVariable("id") Long id, @RequestBody Post post) {
        if (id == null) throw new RuntimeException("ID is null");
        if (post == null) throw new RuntimeException("Entity is null");
        if(!id.equals(post.getId())) throw new RuntimeException("Id is not matched");
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id") long id) {
        postService.delete(id);
        return new ResponseEntity<>("Post deleted successfully!", HttpStatus.OK);
    }


}
