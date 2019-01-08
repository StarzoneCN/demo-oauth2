package com.example.oauth2.serverclient.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/**
 * 授权认证配置类
 *
 * @author: LiHongxing
 * @email: lihongxing@bluemoon.com.cn
 * @date: Create in 2019/1/4 10:06
 * @modefied:
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // 使用in-memory存储
                .withClient("client") // client_id
                    .secret("secret") // client_secret
                    .authorizedGrantTypes("authorization_code") // 该client允许的授权类型
                    .scopes("app"); // 允许的授权范围
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //enable client to get the authenticated when using the /oauth/token to get a access token
        //there is a 401 authentication is required if it doesn't allow form authentication for clients when access /oauth/token
        oauthServer.allowFormAuthenticationForClients();
    }
}
