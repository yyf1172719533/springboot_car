package com.timain.web.sys.service;

import com.timain.web.sys.common.DataGridView;
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
}
