package com.oguzhanserttas.mediumblog.repository;

import com.oguzhanserttas.mediumblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository <Post, Long> {
}
