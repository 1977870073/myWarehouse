package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentHouseinfo;
import com.cozyBed.renting_Admin.po.RentHouseinfoExample;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public interface RentHouseinfoMapper {
    long countByExample(RentHouseinfoExample example);

    int deleteByExample(RentHouseinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentHouseinfoWithBLOBs record);

    int insertSelective(RentHouseinfoWithBLOBs record);

    @Cacheable(value = "hinfo")
    List<RentHouseinfoWithBLOBs> selectByExampleWithBLOBs(RentHouseinfoExample example);
    @Cacheable(value = "hinfo")
    List<RentHouseinfo> selectByExample(RentHouseinfoExample example);
    @Cacheable(value = "hinfo")
    RentHouseinfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentHouseinfoWithBLOBs record, @Param("example") RentHouseinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") RentHouseinfoWithBLOBs record, @Param("example") RentHouseinfoExample example);

    int updateByExample(@Param("record") RentHouseinfo record, @Param("example") RentHouseinfoExample example);

    int updateByPrimaryKeySelective(RentHouseinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RentHouseinfoWithBLOBs record);

    int updateByPrimaryKey(RentHouseinfo record);
}