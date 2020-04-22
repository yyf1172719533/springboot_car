package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/22 16:00
 */
public interface UserMapper extends JpaRepository<User, Integer> {
}
