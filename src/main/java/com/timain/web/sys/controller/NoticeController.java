package com.timain.web.sys.controller;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.service.NoticeService;
import com.timain.web.sys.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 9:16
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    
    @Autowired
    private NoticeService noticeService;

    /**
     * 查询所有公告信息
     * @param noticeVO
     * @return
     */
    @RequestMapping("loadAllNotices")
    public DataGridView loadAllNotices(NoticeVO noticeVO) {
        return noticeService.findAllNotices(noticeVO);
    }
}
