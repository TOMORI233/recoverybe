package com.recovery.dao;

import com.recovery.entity.UserBaseInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface
UserBaseInfoRepository extends JpaRepository<UserBaseInfo, Long> {
    Optional<UserBaseInfo> findByUserID(Long userID);
}
