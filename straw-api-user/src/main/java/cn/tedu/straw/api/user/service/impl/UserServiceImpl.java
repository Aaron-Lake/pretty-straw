package cn.tedu.straw.api.user.service.impl;

import cn.tedu.straw.api.user.dto.RegisterStudentDTO;
import cn.tedu.straw.api.user.ex.ClassDisableException;
import cn.tedu.straw.api.user.ex.InsertException;
import cn.tedu.straw.api.user.ex.InviteCodeException;
import cn.tedu.straw.api.user.ex.PhoneDuplicateException;
import cn.tedu.straw.api.user.mapper.ClassInfoMapper;
import cn.tedu.straw.commons.model.ClassInfo;
import cn.tedu.straw.commons.model.User;
import cn.tedu.straw.api.user.mapper.UserMapper;
import cn.tedu.straw.api.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.PasswordUtils;

import java.time.LocalDateTime;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    UserMapper userMapper;

    @Override
    public void registerStudent(RegisterStudentDTO registerStudentDTO) {
        ClassInfo classInfo = classInfoMapper.findByInviteCode(registerStudentDTO.getInviteCode());
        if(classInfo == null){
            throw  new InviteCodeException("邀请码错误！");
        }
        if(classInfo.getIsEnabled()==0){
            throw  new ClassDisableException("该班级已被停用！");
        }
        User user = userMapper.findByPhone(registerStudentDTO.getPhone());
        if (user!=null){
            throw  new PhoneDuplicateException("该手机号已被注册！");
        }

        LocalDateTime now = LocalDateTime.now();
        User student = new User().setUsername(registerStudentDTO.getPhone()).setNickname(registerStudentDTO.getNickname())
                .setPassword(PasswordUtils.encode(registerStudentDTO.getPassword())).setPhone(registerStudentDTO.getPhone()).setClassId(classInfo.getId())
                .setIsEnabled(1).setIsLocked(0).setAccountType(0).setGmtCreate(now).setGmtModified(now);

        int rows = userMapper.insert(student);
        if (rows!=1){
            throw new InsertException("服务器忙！请稍后再试！");
        }
    }
}
