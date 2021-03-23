package cn.tedu.straw.api.user.mapper;

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
    /**
     * 根据phone查询User表
     * @param phone
     * @return
     */
    public User findByPhone(String phone);

}
