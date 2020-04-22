package com.timain.web.sys.dto;

import com.timain.web.sys.pojo.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author yyf
 * @Version 1.0
 * @Date 2020/4/22 0022 19:55
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private User user;
    private List<String> roles;
    private List<String> menus;
}
