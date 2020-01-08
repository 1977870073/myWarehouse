package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentAppointmentMapper;
import com.cozyBed.renting_Admin.mapper.RentAppointmentMapperExpand;
import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapper;
import com.cozyBed.renting_Admin.mapper.RentUserMapper;
import com.cozyBed.renting_Admin.po.*;
import com.cozyBed.renting_Admin.service.RentAppointmentService;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private RentAppointmentMapperExpand rentAppointmentMapperExpand;

    @Override
    public Object[] getAppointmentInfo(String user,Integer page, Integer limit, Integer type) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("fd",user);
        paramMap.put("flag",0);
        paramMap.put("sendType",type);
        paramMap.put("page",page);
        paramMap.put("pagesize",limit);
        Integer num = rentAppointmentMapperExpand.selectInfoCount(paramMap);
        List<Map<String, Object>> rtList = rentAppointmentMapperExpand.selectInfo(paramMap);
        return new Object[]{rtList, num};
    }

    @Override
    public Map<String, Object> getAppointmentInfoById(Integer id) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id",id);
        return rentAppointmentMapperExpand.selectInfoById(paramMap);
    }

    @Override
    public Integer updateAppointmentFlag(Integer id, Integer flag) {
        RentAppointment tt = new RentAppointment();
        tt.setFlag(flag);
        tt.setId(id);
        return rentAppointmentMapper.updateByPrimaryKeySelective(tt);
    }

    @Override
    public Integer updateAppointmentFlag(Integer id, Integer flag, String time) {
        RentAppointment tt = new RentAppointment();
        tt.setFlag(flag);
        tt.setUtime(time);
        tt.setId(id);
        return rentAppointmentMapper.updateByPrimaryKeySelective(tt);
    }
}
