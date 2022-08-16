package com.oguzhanserttas.mediumblog.service.impl;

import com.oguzhanserttas.mediumblog.configuration.MediumProperties;
import com.oguzhanserttas.mediumblog.model.MediumPost;
import com.oguzhanserttas.mediumblog.model.Post;
import com.oguzhanserttas.mediumblog.service.PostIntegration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Collections;

@Service
public class PostIntegrationImpl implements PostIntegration {

    private MediumProperties mediumProperties;

    public PostIntegrationImpl(MediumProperties mediumProperties) {
        this.mediumProperties = mediumProperties;
    }

    @Override
    public void sendPost(Post post) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        String userid = mediumProperties.getUserId();
        String accesstoken = mediumProperties.getAccesstoken();
        String url = "https://api.medium.com/v1/users/" + userid + "/posts?accessToken=" + accesstoken;
        MediumPost mediumPost = new MediumPost();
        mediumPost.setContent("<h1>" + post.getTitle() + "</h1><p>" + post.getContent() + "</p>");
        mediumPost.setTitle(post.getTitle());
        mediumPost.setContentFormat("html");
        mediumPost.setPublishStatus("public");

        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        HttpEntity<MediumPost> request = new HttpEntity<>(mediumPost, headers);

        restTemplate.postForEntity(url, request, MediumPost.class);

    }
}
