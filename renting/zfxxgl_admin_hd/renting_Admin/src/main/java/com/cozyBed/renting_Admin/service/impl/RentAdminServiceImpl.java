package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentAdminMapper;
import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import com.cozyBed.renting_Admin.service.RentAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: RentAdminServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@Service
public class RentAdminServiceImpl implements RentAdminService {
    @Autowired
    private RentAdminMapper rentAdminMapper;
    @Override
    public List<RentAdmin> findByExample(RentAdminExample example) throws Exception {
        List<RentAdmin> list = rentAdminMapper.selectByExample(example);
        if(list==null){
            return null;
        }
        return list;
    }
}
