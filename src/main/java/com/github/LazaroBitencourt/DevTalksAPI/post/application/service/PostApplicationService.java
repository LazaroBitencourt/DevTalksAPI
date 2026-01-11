package com.github.LazaroBitencourt.DevTalksAPI.post.application.service;

import com.github.LazaroBitencourt.DevTalksAPI.category.application.repository.CategoryRepository;
import com.github.LazaroBitencourt.DevTalksAPI.category.domain.Category;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostIdResponse;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.api.PostRequest;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.repository.PostRepository;
import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.repository.UserRepository;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PostApplicationService implements PostService{
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    @Override
    public PostIdResponse createNewPost(PostRequest postRequest) {
        log.info("[start] PostApplicationService - createNewPost");
        User user = userRepository.findUserById(postRequest.idAuthor());
        Post post = new Post(postRequest,user);
        postRepository.save(post);
        log.info("[finish] PostApplicationService - createNewPost");
        return PostIdResponse.builder().idPost(post.getIdPost()).build();
    }
}

