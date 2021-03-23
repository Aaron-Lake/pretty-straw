package cn.tedu.straw.commons.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


import java.util.Collection;

@Setter
@Getter
public class UserInfo extends User {

    private Integer id;
    private String nickname;

    public UserInfo(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserInfo(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    @Override
    public String toString() {
        return "LoginUserInfo >>> " +
                "id=" + id +
                ", nickname=" + nickname +
                ',' + super.toString();
    }
}
