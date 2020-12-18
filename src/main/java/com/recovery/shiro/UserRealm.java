package com.recovery.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

@Slf4j
public class UserRealm extends AuthorizingRealm {
    // 执行授权逻辑
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("授权");
        // 进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermission("personal");
        return info;
    }

    // 执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("认证");
        // 编写认证逻辑
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 访问数据库获取数据
        // 验证通过返回用户信息dto
//        return new SimpleAuthenticationInfo(userInfoDto, token.getPassword(), getName());
        return new SimpleAuthenticationInfo(null, token.getPassword(), getName());
    }
}
