package cn.tedu.straw.api.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Getter
@Setter
public class RegisterStudentDTO implements Serializable {

    @NotBlank(message = "邀请码不能为空！")
    private String inviteCode;
    @Pattern(regexp = "^\\d{11}$",message = "手机格式错误！")
    private String phone;
    @NotBlank(message = "昵称不能为空！")
    private String nickname;
    @Pattern(regexp = "^\\w{4,17}$",message = "密码格式错误！")
    private String password;
}
