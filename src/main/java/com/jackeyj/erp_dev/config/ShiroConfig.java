package com.jackeyj.erp_dev.config;

import com.jackeyj.erp_dev.shiro.realms.UserRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 整合shiro框架相关配置类
 * @author jiyaofei
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);

        Map<String, String> map = new HashMap<>();
        //authc告诉请求这个资源需要认证和授权
        map.put("/sys/index", "authc");
        map.put("/sys/login", "anon");
        map.put("/", "anon");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);

        shiroFilterFactoryBean.setLoginUrl("/sys/login");

        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm realm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }


}
