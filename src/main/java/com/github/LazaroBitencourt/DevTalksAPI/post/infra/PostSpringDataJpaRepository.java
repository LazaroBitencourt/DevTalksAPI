package com.github.LazaroBitencourt.DevTalksAPI.post.infra;

import com.github.LazaroBitencourt.DevTalksAPI.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostSpringDataJpaRepository extends JpaRepository<Post, UUID> {
}
