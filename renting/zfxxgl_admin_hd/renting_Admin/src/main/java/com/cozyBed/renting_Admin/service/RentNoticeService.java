package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentNotice;

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
     * 是否有新的消息
     * @param user
     * @return
     */
    public Integer hasNewNote(String user);
}
