package com.oguzhanserttas.mediumblog.service;

import com.oguzhanserttas.mediumblog.model.MediumPost;
import com.oguzhanserttas.mediumblog.model.Post;

public interface PostIntegration {
    void sendPost(Post post);
}
