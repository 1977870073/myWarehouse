package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentNoticeMapper;
import com.cozyBed.renting_Admin.po.RentNotice;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>Title: RentNoticeServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/15
 */
@Service
public class RentNoticeServiceImpl implements RentNoticeService {
    @Autowired
    private RentNoticeMapper noticeMapper;

    /**
     * 插入通知
     * @param notice
     * @return
     * @throws Exception
     */
    @Override
    public Integer insert(RentNotice notice) throws Exception {
        return noticeMapper.insertSelective(notice);
    }
    /**
     * 是否有新的消息
     * @param user
     * @return
     */
    @Override
    public Integer hasNewNote(String user) {
        return null;
    }
}
