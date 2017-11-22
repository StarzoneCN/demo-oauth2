package com.example.demooauth2.mapper;

import com.example.demooauth2.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Li Hongxing
 * @since 2017-11-22
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User loadUserByUsername(@Param("username") String username);
}
