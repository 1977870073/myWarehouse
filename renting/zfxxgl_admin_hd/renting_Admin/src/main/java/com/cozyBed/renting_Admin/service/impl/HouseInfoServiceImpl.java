package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapper;
import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapperExpand;
import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title: HouseInfoServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
@Service
public class HouseInfoServiceImpl implements HouseInfoService {
    @Autowired
    private RentHouseinfoMapperExpand rentHouseinfoMapperExpand;
    @Autowired
    private RentHouseinfoMapper rentHouseinfoMapper;

    public List<RentHouseinfoWithBLOBsExpand> selectInfoes(Choose choose) throws Exception {
        return rentHouseinfoMapperExpand.selectInfoes(choose);
    }

    public long infoCount(Choose choose) throws Exception {
        return rentHouseinfoMapperExpand.infoCount(choose);
    }

    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id) throws Exception {
        return rentHouseinfoMapperExpand.findByPrimaryKey(id);
    }

    @Override
    public RentHouseinfoWithBLOBs findByPrimaryKeyOther(Integer id) throws Exception {
        return rentHouseinfoMapper.selectByPrimaryKey(id);
    }

    public List<RentHouseinfoWithBLOBs> selectBySearch(String search) throws Exception {
        return rentHouseinfoMapperExpand.selectBySearch(search);
    }

    public int insertInfo(RentHouseinfoWithBLOBs info) throws Exception {
        return rentHouseinfoMapper.insertSelective(info);
    }

    @Override
    public List<RentHouseinfoWithBLOBs> selectByUser(String user, String userType, Integer index) throws Exception {
        return rentHouseinfoMapperExpand.userHouse(user,userType, index);
    }

    @Override
    public long selectByUserCount(String user, String userType) throws Exception {
        return rentHouseinfoMapperExpand.userHouseCount(user,userType);
    }

    @Override
    public int updateByPrimaryKeySelective(RentHouseinfoWithBLOBs record) throws Exception {
        return rentHouseinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return rentHouseinfoMapper.deleteByPrimaryKey(id);
    }
}
