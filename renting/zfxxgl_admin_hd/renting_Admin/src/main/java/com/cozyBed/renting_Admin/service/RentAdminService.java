package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;

import java.util.List;

/**
 * <p>Title: RentAdminService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
public interface RentAdminService {
    public List<RentAdmin> findByExample(RentAdminExample example)throws Exception;
}
