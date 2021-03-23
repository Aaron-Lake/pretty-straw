package cn.tedu.straw.api.user.service.impl;

import cn.tedu.straw.api.user.model.Permission;
import cn.tedu.straw.api.user.mapper.PermissionMapper;
import cn.tedu.straw.api.user.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-14
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
