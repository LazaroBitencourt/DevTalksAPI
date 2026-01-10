package com.github.LazaroBitencourt.DevTalksAPI.post.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/post")
public interface PostApi {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public PostIdResponse postCreateNewPost(@RequestBody PostRequest postRequest);
}
