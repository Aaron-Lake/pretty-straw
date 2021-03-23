package cn.tedu.straw.api.user.mapper;

import cn.tedu.straw.commons.model.ClassInfo;
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
public interface ClassInfoMapper extends BaseMapper<ClassInfo> {
    /**
     * 根据inviteCode查询class_info表
     * @param inviteCode
     * @return
     */
    public ClassInfo findByInviteCode(String inviteCode);

}
