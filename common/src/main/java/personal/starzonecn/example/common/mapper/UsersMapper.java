package personal.starzonecn.example.common.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import personal.starzonecn.example.common.entity.Users;

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
