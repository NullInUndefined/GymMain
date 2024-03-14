package com.example.config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();

        // 注册自定义CORS过滤器
        Map<String, Filter> filters = new HashMap<>();
        filters.put("corsFilter", new CorsFilter());
        shiroFilter.setFilters(filters);

        // 在所有其他规则之前，应用自定义CORS过滤器
        filterChainDefinitionMap.put("/**", "corsFilter");

        //管理员权限页面
        filterChainDefinitionMap.put("/AdminMem/**", "authc, roles[Admin]");
        filterChainDefinitionMap.put("/AdminCur/**", "authc, roles[Admin]");
        filterChainDefinitionMap.put("/AdminCoa/**", "authc, roles[Admin]");
        filterChainDefinitionMap.put("/adminorder/**", "authc, roles[Admin]");
        //会员权限页面
        filterChainDefinitionMap.put("/ordcoach/**", "authc, roles[Member]");
        filterChainDefinitionMap.put("/purcurse/**", "authc, roles[Member]");

        filterChainDefinitionMap.put("/loginAndRegister/**", "anon");
        filterChainDefinitionMap.put("/logout/**", "anon");

        filterChainDefinitionMap.put("/logout", "logout");

        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilter;
    }

}
