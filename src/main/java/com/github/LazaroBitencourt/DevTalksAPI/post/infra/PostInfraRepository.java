package com.github.LazaroBitencourt.DevTalksAPI.post.infra;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import com.github.LazaroBitencourt.DevTalksAPI.post.application.repository.PostRepository;
import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PostInfraRepository implements PostRepository{
    private final PostSpringDataJpaRepository jpaRepository;

    @Override
    public Post save(Post post) {
        log.info("[start] PostInfraRepository - save");
        try{
            jpaRepository.save(post);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"THERE ARE DUPLICATE DATA", e);
        }

        log.info("[finish] PostInfraRepository - save");
        return post;

    }
}
