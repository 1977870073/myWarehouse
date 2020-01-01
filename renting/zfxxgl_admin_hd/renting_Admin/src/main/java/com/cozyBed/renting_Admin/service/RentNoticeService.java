package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentNotice;

import java.util.List;

/**
 * <p>Title: RentNoticeService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/15
 */
public interface RentNoticeService {
    /**
     * 插入通知
     * @param notice
     * @return
     * @throws Exception
     */
    public Integer insert(RentNotice notice)throws Exception;

    /**
     * 获取发送给房东的消息
     * @param user
     * @return
     */
    public List<RentNotice> getNotice(String user)throws Exception;

    /**
     * 修改房东通知状态
     * @param user
     * @param flag
     * @return
     * @throws Exception
     */
    public Integer updateNoticFlagToFD(String user, Integer flag)throws  Exception;
}
