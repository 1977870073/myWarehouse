package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
    /**
     * 返回指定位置的40条记录
     * @param choose
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public List<RentHouseinfoWithBLOBsExpand> selectInfoes(Choose choose)throws Exception;

    /**
     * 返回RentHouseinfoWithBLOBsExpand类型的数据,显示房源详细信息
     * @param id
     * @return
     * @throws Exception
     */
    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id)throws Exception;

    /**
     * 返回显示的数据数量
     * @param choose
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public long infoCount(Choose choose)throws Exception;

    /**
     * 返回搜索数据的前40条
     * @param search
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public List<RentHouseinfoWithBLOBs> selectBySearch(String search)throws Exception;

    /**
     * 返回属于user的房源数量
     * @param user
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public long userHouseCount(@Param("user") String user, @Param("userType") String userType)throws Exception;

    /**
     * 返回40条user的房源
     * @param user
     * @param index
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public List<RentHouseinfoWithBLOBs> userHouse(@Param("user") String user, @Param("userType") String userType, @Param("index") Integer index)throws Exception;

    /**
     * 获取一个7天内后台发布的房源数
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public List<Map<String, Object>> selectWeekCountForHT()throws Exception;

    /**
     * 获取一个7天内用户发布的房源数
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public List<Map<String, Object>> selectWeekCountForYH()throws Exception;

    /**
     * 获取一个月内后台发布的房源数
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public Integer selectMonthCountForHT()throws Exception;

    /**
     * 获取一个月内用户发布的房源数
     * @return
     * @throws Exception
     */
    @Cacheable(value = "hinfo")
    public Integer selectMonthCountForYH()throws Exception;
}
