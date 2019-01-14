package personal.starzonecn.example.common.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import personal.starzonecn.example.common.entity.Users;
import personal.starzonecn.example.common.mapper.UsersMapper;
import personal.starzonecn.example.common.service.UsersService;

import java.io.Serializable;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author LiHongxing
 * @since 2019-01-07
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService,Serializable {

}
