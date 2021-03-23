package cn.tedu.straw.api.question.controller;

import cn.tedu.straw.api.question.util.RedisUtils;
import cn.tedu.straw.commons.model.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/tags")
public class TagController {

    @Autowired
    RedisUtils redisUtils;


    @RequestMapping("")
    public R tag(){
        return R.ok(redisUtils.ListRange("tags"));
    }
}
