package com.timain.web.sys.service.impl;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.pojo.Notices;
import com.timain.web.sys.service.NoticeService;
import com.timain.web.sys.vo.NoticeVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yyf
 * @version 1.0
 * @date 2020/4/24 11:24
 */
@SpringBootTest
class NoticeServiceImplTest {
    
    @Autowired
    private NoticeService noticeService;

    @Test
    void findAllNotices() {
        NoticeVO noticeVO = new NoticeVO();
        noticeVO.setTitle("关于系统V1.0发布公告");
        DataGridView dataGridView = noticeService.findAllNotices(noticeVO);
        System.out.println(dataGridView);
    }
    
    @Test
    @Transactional
    void addNotices() {
        Notices notices = new Notices();
        notices.setContent("1111");
        notices.setTitle("1111");
        notices.setCreateTime(new Date());
        notices.setOperName("1111");
        this.noticeService.saveOrUpdateNotice(notices);
    }
}