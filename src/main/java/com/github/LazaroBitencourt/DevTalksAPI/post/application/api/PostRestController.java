package com.github.LazaroBitencourt.DevTalksAPI.post.application.api;

import com.github.LazaroBitencourt.DevTalksAPI.post.application.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PostRestController implements PostApi {
    private final PostService postService;

    @Override
    public PostIdResponse postCreateNewPost(PostRequest postRequest) {
        log.info("[start] PostRestController - postCreateNewPost");
        PostIdResponse post = postService.createNewPost(postRequest);
        log.info("[finish] PostRestController - postCreateNewPost");
        return post;
    }
}
