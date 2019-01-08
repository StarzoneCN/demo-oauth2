package personal.starzonecn.example.oauth2.resource.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import personal.starzonecn.example.oauth2.resource.entity.Users;
import personal.starzonecn.example.oauth2.resource.mapper.UsersMapper;
import personal.starzonecn.example.oauth2.resource.service.UsersService;

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
