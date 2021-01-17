package com.recovery.dao;

import com.recovery.entity.UserAuths;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthsRepository extends JpaRepository<UserAuths, Long> {

    Optional<UserAuths> findByPhoneAndPassword(String phone, String password);
}
