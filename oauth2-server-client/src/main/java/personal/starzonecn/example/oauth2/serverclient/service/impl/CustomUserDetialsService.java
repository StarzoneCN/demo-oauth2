package personal.starzonecn.example.oauth2.serverclient.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author: Li Hongxing
 * @description: UserDetialsService的jdbc实现
 * @date: Created in 2017/12/02 10:27
 * @modified:
 */
@Service
@Primary
public class CustomUserDetialsService extends JdbcUserDetailsManager {

    @Resource private DataSource customDataSource;

    @PostConstruct
    public void init(){
        this.setDataSource(customDataSource);
    }
}
