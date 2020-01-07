package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentAppointmentMapper;
import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapper;
import com.cozyBed.renting_Admin.mapper.RentUserMapper;
import com.cozyBed.renting_Admin.po.*;
import com.cozyBed.renting_Admin.service.RentAppointmentService;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service.impl
 * @ClassName: RentAppointmentServiceImpl
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2020/1/4 23:27
 * @Version: 1.0
 */
@Service
public class RentAppointmentServiceImpl implements RentAppointmentService {
    @Autowired
    private RentAppointmentMapper rentAppointmentMapper;
    @Autowired
    private RentHouseinfoMapper rentHouseinfoMapper;
    @Autowired
    private RentUserMapper rentUserMapper;

    @Override
    public Object[] getAppointmentInfo(String user,Integer page) {
        List<RentAppointmentExtends> rtList = new ArrayList<>();
        RentAppointmentExample example = new RentAppointmentExample();
        RentAppointmentExample.Criteria criteria = example.createCriteria();
        criteria.andFdEqualTo(user);
        criteria.andFlagEqualTo(0);
        List<RentAppointment> rsList = rentAppointmentMapper.selectByExample(example);
        if(ObjectUtil.isEmply(rsList)){
            return null;
        }
        int i = (page-1)*10;
        int len = (rsList.size()>page*10)?page*10:rsList.size();
        for(; i<len;i++){
            RentAppointment r = rsList.get(i);
            RentAppointmentExtends rex = new RentAppointmentExtends();
            rex.setRownum(i+1);
            rex.setId(r.getId());
            rex.setUser(r.getUser());
            rex.setFd(r.getFd());
            rex.setUphone(r.getUphone());
            rex.setUtime(r.getUtime());
            rex.setHouse(r.getHouse());
            rex.setBeizhu(r.getBeizhu());
            rex.setFlag(r.getFlag());
            //获取房源标题
            RentHouseinfoWithBLOBs houseinfo = rentHouseinfoMapper.selectByPrimaryKey(r.getHouse());
            if(houseinfo==null){
                continue;
            }
            rex.setTitle(houseinfo.getTitle());
            //获取用户昵称
            RentUserExample userExample = new RentUserExample();
            RentUserExample.Criteria userCriteria = userExample.createCriteria();
            userCriteria.andUsernameEqualTo(r.getUser());
            userCriteria.andUsertypeEqualTo("0");
            List<RentUser> userList = rentUserMapper.selectByExample(userExample);
            if(ObjectUtil.isEmply(userList)){
                continue;
            }
            rex.setUserName(userList.get(0).getName());
            rtList.add(rex);
        }
        return new Object[]{rtList, rsList.size()};
    }

    @Override
    public Integer updateAppointmentFlag(Integer id, Integer flag) {
        RentAppointment tt = new RentAppointment();
        tt.setFlag(flag);
        tt.setId(id);
        return rentAppointmentMapper.updateByPrimaryKeySelective(tt);
    }
}
