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


    @Override
    public int insert(RentNotice notice) throws Exception {
        return noticeMapper.insertSelective(notice);
    }
}
