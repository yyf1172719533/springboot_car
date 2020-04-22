package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.security.RunAs;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:09
 */

@SpringBootTest
class UserMapperTest {
    
    @Autowired
    private UserMapper userMapper;
    
    @Test
    void testFindUser() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

}