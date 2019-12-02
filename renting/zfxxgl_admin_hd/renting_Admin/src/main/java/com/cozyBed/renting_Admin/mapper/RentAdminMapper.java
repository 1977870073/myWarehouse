package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentAdminMapper {
    long countByExample(RentAdminExample example);

    int deleteByExample(RentAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentAdmin record);

    int insertSelective(RentAdmin record);

    List<RentAdmin> selectByExample(RentAdminExample example);

    RentAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentAdmin record, @Param("example") RentAdminExample example);

    int updateByExample(@Param("record") RentAdmin record, @Param("example") RentAdminExample example);

    int updateByPrimaryKeySelective(RentAdmin record);

    int updateByPrimaryKey(RentAdmin record);
}