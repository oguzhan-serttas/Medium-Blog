package com.oguzhanserttas.mediumblog.service.impl;

import com.oguzhanserttas.mediumblog.configuration.MediumAccountConfiguration;
import com.oguzhanserttas.mediumblog.model.MediumPost;
import com.oguzhanserttas.mediumblog.model.Post;
import com.oguzhanserttas.mediumblog.service.PostIntegration;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.Arrays;
import java.util.Collections;

@Service
public class MediumPostIntegrationImpl implements PostIntegration {

    private final MediumAccountConfiguration mediumProperties;
    private final RestTemplate restTemplate;

    public MediumPostIntegrationImpl(MediumAccountConfiguration mediumProperties, RestTemplate restTemplate) {
        this.mediumProperties = mediumProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendPost(Post post) {

        final String userId = mediumProperties.getUserId();
        final String accessToken = mediumProperties.getAccessToken();
        final String url = "https://api.medium.com/v1/users/" + userId + "/posts?accessToken=" + accessToken;

        final MediumPost mediumPost = new MediumPost();
        mediumPost.setContent("<h1>" + post.getTitle() + "</h1><p>" + post.getContent() + "</p>");
        mediumPost.setTitle(post.getTitle());
        mediumPost.setContentFormat("html");
        mediumPost.setPublishStatus("public");

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        final HttpEntity<MediumPost> request = new HttpEntity<>(mediumPost, headers);

        try {
            restTemplate.postForEntity(url, request, MediumPost.class);
        }catch (Exception ex){
            System.out.println("Medium integration error: "+ Arrays.toString(ex.getStackTrace()));
        }
    }
}
