package cn.tedu.straw.api.user.controller;


import cn.tedu.straw.api.user.dto.RegisterStudentDTO;
import cn.tedu.straw.api.user.ex.IllegalParameterException;

import cn.tedu.straw.api.user.service.IUserService;
import cn.tedu.straw.commons.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tedu.cn
 * @since 2021-03-13
 */
@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    IUserService userService;
    // http://localhost:8080/v1/users/reg?password=1234&phone=13000130000&inviteCode=JSD2005-666666&nickname=abcd
    // http://localhost:80/api/v1/users/reg?password=1234&phone=13000130000&inviteCode=JSD2005-666666&nickname=abcd
    // http://localhost/api/v1/users/reg?password=1234&phone=13000130000&inviteCode=JSD2005-666666&nickname=abcd
    @RequestMapping("/reg")
    public R reg(@Valid RegisterStudentDTO registerStudentDTO, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new IllegalParameterException(bindingResult.getFieldError().getDefaultMessage());
        }
        userService.registerStudent(registerStudentDTO);
        return R.OK;
    }
}
