package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentNoticeMapper;
import com.cozyBed.renting_Admin.po.RentNotice;
import com.cozyBed.renting_Admin.po.RentNoticeExample;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<RentNotice> getNotice(String user)throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andFlagEqualTo(1);
        criteria.andUserEqualTo(user);
        criteria.andSendflagEqualTo(1);
        return noticeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 修改房东通知状态
     * @param user
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateNoticFlagToFD(String user, Integer flag) throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andSendflagEqualTo(1);
        RentNotice notice = new RentNotice();
        notice.setFlag(flag);
        return noticeMapper.updateByExampleSelective(notice, example);
    }
}
