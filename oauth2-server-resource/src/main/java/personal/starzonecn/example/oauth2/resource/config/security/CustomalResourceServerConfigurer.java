package personal.starzonecn.example.oauth2.resource.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器配置
 *
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/8 16:46
 * @modefied:
 */
// @Configuration
// @EnableResourceServer
public class CustomalResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/oauth/**", "/login").permitAll()
                .anyRequest().authenticated().and()
                .formLogin().permitAll().and()
                .rememberMe()
                .key("starzoneCN")
                .rememberMeParameter("rememberMe")
                .rememberMeCookieName("warplaneInLaji")
                .tokenValiditySeconds(60 * 60).and()
                .httpBasic().and()
                /*为了方便使用postman进行测试，此处关闭csrf*/
                .csrf().disable();
    }
}
