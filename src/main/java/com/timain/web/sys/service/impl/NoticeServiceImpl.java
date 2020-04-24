package com.timain.web.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.mapper.NoticesMapper;
import com.timain.web.sys.pojo.Notices;
import com.timain.web.sys.service.NoticeService;
import com.timain.web.sys.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:11
 */
@Service
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
        Page<Object> page = new Page<>(noticeVO.getPage(), noticeVO.getLimit());
        List<Notices> notices = noticesMapper.findAll(((root, criteriaQuery, criteriaBuilder) -> {
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
                                criteriaBuilder.ge(
                                        root.get("startTime"), (Expression<? extends Number>) noticeVO.getStartTime()
                                )
                        )
                );
            }
            if (null!=noticeVO.getEndTime()) {
                predicateList.add(
                        criteriaBuilder.and(
                                criteriaBuilder.ge(
                                        root.get("endTime"), (Expression<? extends Number>) noticeVO.getEndTime()
                                )
                        )
                );
            }
            return criteriaBuilder.and(
                    predicateList.toArray(new Predicate[predicateList.size()])
            );
        }));
        return new DataGridView(page.getTotal(), notices);
    }
}