package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentUserMapper;
import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;
import com.cozyBed.renting_Admin.service.RentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service.impl
 * @ClassName: RentUserServiceImpl
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2020/1/4 16:48
 * @Version: 1.0
 */
@Service
public class RentUserServiceImpl implements RentUserService {
    @Autowired
    private RentUserMapper rentUserMapper;

    @Override
    public List<RentUser> getUserInfo(String user, String type) {
        RentUserExample example = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user);
        criteria.andUsertypeEqualTo(type);
        return rentUserMapper.selectByExample(example);
    }

    @Override
    public Integer updateUser(String user, String type, String email, String name) {
        RentUserExample example = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user);
        criteria.andUsertypeEqualTo(type);
        RentUser u = new RentUser();
        u.setEmail(email);
        u.setName(name);
        return rentUserMapper.updateByExampleSelective(u, example);
    }
}
