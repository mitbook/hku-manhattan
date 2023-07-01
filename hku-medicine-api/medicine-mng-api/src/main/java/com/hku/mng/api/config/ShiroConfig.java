package com.hku.mng.api.config;

import com.hku.mng.api.custom.CustomRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author pengzhengfa
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        filterFactoryBean.setSecurityManager(securityManager);
        /**
         * 设置未登录时的跳转页面
         */
        filterFactoryBean.setLoginUrl("/login");
        /**
         * 设置无权限时的跳转页面
         */
        filterFactoryBean.setUnauthorizedUrl("/unauthorized");
        /**
         * 设置拦截器规则
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        /**
         * 公共资源，无需登录即可访问
         */
        filterChainDefinitionMap.put("/login", "anon");
        /**
         * 其他资源需要进行认证和授权
         */
        filterChainDefinitionMap.put("/**", "authc");
        filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(Realm realm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        return securityManager;
    }

    @Bean
    public Realm realm() {
        CustomRealm realm = new CustomRealm();
        /**
         * 配置密码比较器
         */
        realm.setCredentialsMatcher(credentialsMatcher());
        return realm;
    }

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        /**
         * 设置加密算法
         */
        credentialsMatcher.setHashAlgorithmName("SHA-256");
        /**
         * 设置加密次数
         */
        credentialsMatcher.setHashIterations(1);
        return credentialsMatcher;
    }
}
