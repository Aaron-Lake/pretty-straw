package cn.tedu.straw.api.user.service;

import cn.tedu.straw.api.user.dto.RegisterStudentDTO;
import cn.tedu.straw.commons.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-13
 */
public interface IUserService extends IService<User> {

    /**
     * 注册学生账号
     * @param registerStudentDTO
     */
    public void registerStudent(RegisterStudentDTO registerStudentDTO);
}
