package com.oguzhanserttas.mediumblog.service.impl;

import com.oguzhanserttas.mediumblog.model.Post;
import com.oguzhanserttas.mediumblog.service.PostIntegration;

public class WordPressPostIntegration implements PostIntegration {
    @Override
    public void sendPost(Post post) {
        throw new RuntimeException("Unsupported");
    }
}
