package com.timain.web.sys.service;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.pojo.Notices;
import com.timain.web.sys.vo.NoticeVO;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:11
 */
public interface NoticeService {

    /**
     * 条件查询公告信息并封装
     * @param noticeVO
     * @return
     */
    DataGridView findAllNotices(NoticeVO noticeVO);

    /**
     * 添加或修改公告
     * @param notices
     */
    void saveOrUpdateNotice(Notices notices);

    /**
     * 根据ID删除公告
     * @param id
     */
    void deleteNotice(Integer id);
}
