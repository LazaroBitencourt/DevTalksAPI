package com.github.LazaroBitencourt.DevTalksAPI.user.infra;

import com.github.LazaroBitencourt.DevTalksAPI.handler.APIException;
import com.github.LazaroBitencourt.DevTalksAPI.user.application.repository.UserRepository;
import com.github.LazaroBitencourt.DevTalksAPI.user.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UserInfraRepository implements UserRepository {
    private final UserSpringDataJpaRepository jpaRepository;

    @Override
    public User save(User user) {
        log.info("[start] UserInfraRepository - save");
        try{
            jpaRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw APIException.build(HttpStatus.BAD_REQUEST,"THERE ARE DUPLICATE DATA", e);
        }

        log.info("[finish] UserInfraRepository - save");
        return user;
    }

    @Override
    public User findUserById(UUID idUser) {
        log.info("[start] UserInfraRepository - findUserById");
        var user = jpaRepository.findById(idUser).orElseThrow(()
                -> APIException.build(HttpStatus.NOT_FOUND, "USER NOT FOUND OR DOES NOT EXIST!"
                + " PLEASE PROVIDE A VALID ID OR CONTACT THE SYSTEM ADMINISTRATOR!"
        ));
        return user;
    }

}
