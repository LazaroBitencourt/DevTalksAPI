package com.github.LazaroBitencourt.DevTalksAPI.user.infra;

import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserSpringDataJpaRepository extends JpaRepository<User, UUID> {
}
