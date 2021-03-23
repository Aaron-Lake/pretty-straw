package cn.tedu.straw.gateway.security;

import cn.tedu.straw.commons.model.User;
import cn.tedu.straw.commons.security.UserInfo;
import cn.tedu.straw.gateway.VO.PermissionVO;
import cn.tedu.straw.gateway.mapper.PermissionMapper;
import cn.tedu.straw.gateway.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PermissionMapper permissionMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.findByUsername(username);
        if(user==null){
            return null;
        }
        List<PermissionVO> permissionVOS = permissionMapper.findByUserId(user.getId());

        List<GrantedAuthority> auths= new ArrayList<>();
        for(PermissionVO permissionVO :permissionVOS){
            auths.add(new SimpleGrantedAuthority(permissionVO.getAuthority()));
        }
        UserInfo loginUserInfo = new UserInfo(
                user.getUsername(),
                user.getPassword(),
                user.getIsEnabled() == 1,
                true,
                true,
                user.getIsLocked() == 0,
                auths
        );
        loginUserInfo.setId(user.getId());
        loginUserInfo.setNickname(user.getNickname());

        return  loginUserInfo;
    }
}
