package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.LoginInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:34
 */
public interface LoginInfoMapper extends JpaRepository<LoginInfo, Integer>, JpaSpecificationExecutor {
}
