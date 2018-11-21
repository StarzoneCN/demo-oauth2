package com.example.demooauth2.mybatisPlus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demooauth2.mybatisPlus.entity.User;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LiHongxing
 * @since 2018-10-26
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByIdCustomized(Integer id);
}
