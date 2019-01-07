package com.example.oauth2.serverclient.mapper;

import com.example.oauth2.serverclient.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author LiHongxing
 * @since 2019-01-07
 */
@Mapper
public interface UsersMapper extends BaseMapper<Users> {

}
