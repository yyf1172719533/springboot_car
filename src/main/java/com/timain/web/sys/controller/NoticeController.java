package com.timain.web.sys.controller;

import com.timain.web.sys.common.DataGridView;
import com.timain.web.sys.common.ResultObj;
import com.timain.web.sys.pojo.Notices;
import com.timain.web.sys.pojo.User;
import com.timain.web.sys.service.NoticeService;
import com.timain.web.sys.utils.WebUtils;
import com.timain.web.sys.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    /**
     * 添加公告
     * @param notices
     * @return
     */
    @RequestMapping("addNotice")
    public ResultObj addNotice(Notices notices) {
        try {
            User user = (User) WebUtils.getSession().getAttribute("user");
            notices.setOperName(user.getRealName());
            notices.setCreateTime(new Date());
            this.noticeService.saveOrUpdateNotice(notices);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }
    
    @RequestMapping("updateNotice")
    public ResultObj updateNotice(Notices notices) {
        try {
            User user = (User) WebUtils.getSession().getAttribute("user");
            notices.setId(notices.getId());
            notices.setOperName(user.getRealName());
            notices.setCreateTime(new Date());
            this.noticeService.saveOrUpdateNotice(notices);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @RequestMapping("deleteNotice")
    public ResultObj deleteNotice(Integer id) {
        try {
            this.noticeService.deleteNotice(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     * @param noticeVO
     * @return
     */
    @RequestMapping("deleteBachByIds")
    public ResultObj deleteBachByIds(NoticeVO noticeVO) {
        System.out.println(noticeVO.getIds());
        try {
            Integer[] ids = noticeVO.getIds();
            System.out.println(ids);
            for (Integer id : ids) {
                this.noticeService.deleteNotice(id);
            }
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}
