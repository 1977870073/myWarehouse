package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title: RentHouseinfoMapperExpand</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
@Repository
public interface RentHouseinfoMapperExpand {
    //返回指定位置的40条记录
    public List<RentHouseinfoWithBLOBs> selectInfoes(Choose choose)throws Exception;
    //返回RentHouseinfoWithBLOBsExpand类型的数据,显示房源详细信息
    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id)throws Exception;
    //返回显示的数据数量
    public long infoCount(Choose choose)throws Exception;
    //返回搜索数据的前40条
    public List<RentHouseinfoWithBLOBs> selectBySearch(String search)throws Exception;
    //返回属于user的房源数量
    public long userHouseCount(String user)throws Exception;
    //返回40条user的房源
    public List<RentHouseinfoWithBLOBs> userHouse(@Param("user") String user, @Param("index") Integer index)throws Exception;
}
