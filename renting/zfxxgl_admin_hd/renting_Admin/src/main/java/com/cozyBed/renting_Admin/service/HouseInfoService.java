package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;

import java.util.List;

/**
 * <p>Title: HouseInfoService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
public interface HouseInfoService {
    //返回查询的房源信息
    public List<RentHouseinfoWithBLOBs> selectInfoes(Choose choose)throws Exception;
    //返回查询的房源信息数量
    public long infoCount(Choose choose)throws Exception;
    //返回RentHouseinfoWithBLOBsExpand指定的房源信息
    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id)throws Exception;
    //返回RentHouseinfoWithBLOBs指定的房源信息
    public RentHouseinfoWithBLOBs findByPrimaryKeyOther(Integer id)throws Exception;
    //返回搜索数据的前40条
    public List<RentHouseinfoWithBLOBs> selectBySearch(String search)throws Exception;
    //插入房源信息
    public int insertInfo(RentHouseinfoWithBLOBs info)throws Exception;
    //出租房源信息
    public List<RentHouseinfoWithBLOBs> selectByUser(String user, Integer index)throws Exception;
    //查询出租房源数量
    public long selectByUserCount(String user)throws Exception;
    //修改房源信息
    public int updateByPrimaryKeySelective(RentHouseinfoWithBLOBs record)throws Exception;
    //删除房源信息
    public int deleteByPrimaryKey(Integer id)throws Exception;
}
