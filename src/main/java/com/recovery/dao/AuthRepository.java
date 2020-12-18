package com.recovery.dao;

import com.recovery.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findByPhoneAndPassword(String phone, String password);
}
