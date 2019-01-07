package com.example.oauth2.serverclient.service.impl;

import com.example.oauth2.serverclient.entity.Users;
import com.example.oauth2.serverclient.mapper.UsersMapper;
import com.example.oauth2.serverclient.service.UsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiHongxing
 * @since 2019-01-07
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}
