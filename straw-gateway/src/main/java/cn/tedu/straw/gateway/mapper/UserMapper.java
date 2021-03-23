package cn.tedu.straw.gateway.mapper;

import cn.tedu.straw.commons.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-13
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {

    public User findByUsername(String username);

}
