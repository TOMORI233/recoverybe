package com.recovery.config.system;

import com.recovery.shiro.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    // ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 设置安全关系
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        // 添加Shiro内置过滤器
        // anon：无需认证
        // authc：需要认证
        // user：使用rememberMe时直接访问
        // perms：资源权限访问
        // role：得到角色权限访问
        Map<String, String> filterMap = new LinkedHashMap<>();
        // 拦截优先级从高到低顺序
        filterMap.put("/swagger-ui.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/v2/**", "anon");
        filterMap.put("/swagger-resources/**", "anon");
        filterMap.put("/auth/login", "anon");

//        String personPermission = "perms[person:optional]";
//        String groupPermission = "perms[group:optional]";
//        filterMap.put("/manage/index/count/doctor", personPermission);
//        filterMap.put("manage/index/page/doctor", personPermission);
//        filterMap.put("/user/doctor/list", groupPermission);

//        filterMap.put("/**", "authc");

        // 修改跳转的登录页面
//        shiroFilterFactoryBean.setLoginUrl("/login");
        // 修改未授权时跳转的页面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }

    // DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // Realm
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
