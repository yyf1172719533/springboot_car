package com.timain.web.sys.mapper;

import com.timain.web.sys.pojo.Notices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:10
 */
public interface NoticesMapper extends JpaRepository<Notices, Integer>, JpaSpecificationExecutor {

    
}
