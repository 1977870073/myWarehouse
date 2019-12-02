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
    public int insert(RentNotice notice)throws Exception;
}
