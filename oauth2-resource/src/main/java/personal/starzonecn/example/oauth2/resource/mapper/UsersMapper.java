package personal.starzonecn.example.oauth2.resource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import personal.starzonecn.example.oauth2.resource.entity.Users;

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
