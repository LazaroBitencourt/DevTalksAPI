package com.github.LazaroBitencourt.DevTalksAPI.post.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostRequest;

public interface PostService {

    PostIdResponse createNewPost(PostRequest postRequest);
}
