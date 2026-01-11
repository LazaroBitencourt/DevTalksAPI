package com.github.LazaroBitencourt.DevTalksAPI.post.application.repository;

import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;

public interface PostRepository {
    public Post save(Post post);
}
