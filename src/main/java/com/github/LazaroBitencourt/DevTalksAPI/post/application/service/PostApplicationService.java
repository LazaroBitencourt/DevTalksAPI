package com.github.LazaroBitencourt.DevTalksAPI.post.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostRequest;
import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostApplicationService implements PostService{
    PostRepository repository;
    @Override
    public PostIdResponse createNewPost(PostRequest postRequest) {
        log.info("[start] PostApplicationService - createNewPost");
        Post post = repository.save(PostRequest);
        log.info("[finish] PostApplicationService - createNewPost");
        return PostIdResponse.builder(post).build();
    }
}

