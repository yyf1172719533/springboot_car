package com.timain.web.sys.service.impl;


import com.github.pagehelper.PageHelper;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.NoticesMapper;
import com.timain.web.sys.pojo.Notices;
import com.timain.web.sys.service.NoticeService;
import com.timain.web.sys.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:11
 */
@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {
    
    @Autowired
    private NoticesMapper noticesMapper;
    
    /**
     * 条件查询公告信息并封装
     *
     * @param noticeVO
     * @return
     */
    @Override
    public DataGridView findAllNotices(NoticeVO noticeVO) {
        //Page<Object> page = new Page<>(noticeVO.getPage(), noticeVO.getLimit());
        PageRequest pageRequest = PageRequest.of(noticeVO.getPage() - 1, noticeVO.getLimit());
        Page<Notices> page = noticesMapper.findAll((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();
            //模糊查询
            if (null!=noticeVO.getTitle() && noticeVO.getTitle()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("title"), "%" + noticeVO.getTitle() + "%"
                                )
                        )
                );
            }
            if (null!=noticeVO.getOperName() && noticeVO.getOperName()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("operName"), "%" + noticeVO.getOperName() + "%"
                                )
                        )
                );
            }
            if (null!=noticeVO.getContent() && noticeVO.getContent()!="") {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.like(
                                        root.get("content"), "%" + noticeVO.getContent() + "%"
                                )
                        )
                );
            }
            if (null!=noticeVO.getStartTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                            criteriaBuilder.greaterThanOrEqualTo(
                                        root.<Date>get("createTime"), noticeVO.getStartTime()
                                )
                        )
                );
            }
            if (null!=noticeVO.getEndTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.<Date>get("createTime"), noticeVO.getEndTime()
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
     * 添加或修改公告
     *
     * @param notices
     */
    @Override
    public void saveOrUpdateNotice(Notices notices) {
        this.noticesMapper.save(notices);
    }

    /**
     * 根据ID删除公告
     *
     * @param id
     */
    @Override
    public void deleteNotice(Integer id) {
        this.noticesMapper.deleteById(id);
    }

}
