package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.LoginInfoMapper;
import com.timain.web.sys.pojo.LoginInfo;
import com.timain.web.sys.service.LoginInfoService;
import com.timain.web.sys.vo.LogInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/23 15:36
 */
@Service
@Transactional
public class LoginInfoServiceImpl implements LoginInfoService {
    
    @Autowired
    private LoginInfoMapper loginInfoMapper;

    /**
     * 添加登录日志
     * @param loginInfo
     */
    @Override
    public void save(LoginInfo loginInfo) {
        loginInfoMapper.save(loginInfo);
    }

    /**
     * 条件分页查询所有登录日志信息
     *
     * @param logInfoVO
     * @return
     */
    @Override
    public DataGridView findAllInfos(LogInfoVO logInfoVO) {
        PageRequest pageRequest = PageRequest.of(logInfoVO.getPage() - 1, logInfoVO.getLimit(), Sort.by(Sort.Direction.DESC, "loginTime"));
        Page<LoginInfo> page = this.loginInfoMapper.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            //模糊查询
            if (null!=logInfoVO.getLoginName() && logInfoVO.getLoginName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("loginName"), "%" + logInfoVO.getLoginName() + "%"
                                )
                        )
                );
            }
            if (null!=logInfoVO.getLoginIp() && logInfoVO.getLoginIp()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("loginIp"), "%" + logInfoVO.getLoginIp() + "%"
                                )
                        )
                );
            }
            if (null!=logInfoVO.getStartTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.<Date>get("loginTime"), logInfoVO.getStartTime()
                                )
                        )
                );
            }
            if (null!=logInfoVO.getEndTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.<Date>get("loginTime"), logInfoVO.getEndTime()
                                )
                        )
                );
            }
            return criteriaBuilder.and(
                    predicateList.toArray(new Predicate[predicateList.size()])
            );
        }, pageRequest);
        return new DataGridView(page.getTotalElements(), page.getContent());
    }

    /**
     * 根据ID删除登录日志信息
     *
     * @param id
     */
    @Override
    public void deleteInfos(Integer id) {
        this.loginInfoMapper.deleteById(id);
    }
}
