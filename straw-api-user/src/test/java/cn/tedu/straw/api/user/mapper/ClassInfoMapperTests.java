package cn.tedu.straw.api.user.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClassInfoMapperTests {

    @Autowired
    ClassInfoMapper classInfoMapper;
    @Autowired
    UserMapper userMapper;

    @Test
    void a(){
        System.out.println(classInfoMapper.findByInviteCode("JSD2005-666666"));
        System.out.println(userMapper.findByPhone("18000000001"));
    }
}
