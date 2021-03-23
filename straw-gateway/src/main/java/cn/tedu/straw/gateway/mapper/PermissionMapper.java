package cn.tedu.straw.gateway.mapper;

import cn.tedu.straw.commons.model.Permission;
import cn.tedu.straw.gateway.VO.PermissionVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-14
 */
@Repository
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据user的id关联查询permissionVO信息
     * @param userId
     * @return id,authority,description
     */
    public List<PermissionVO> findByUserId(Integer userId);
}
