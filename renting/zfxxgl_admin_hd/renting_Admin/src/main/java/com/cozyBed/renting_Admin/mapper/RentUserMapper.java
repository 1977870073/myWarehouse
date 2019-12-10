package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentUserMapper {
    long countByExample(RentUserExample example);

    int deleteByExample(RentUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentUser record);

    int insertSelective(RentUser record);

    List<RentUser> selectByExample(RentUserExample example);

    RentUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentUser record, @Param("example") RentUserExample example);

    int updateByExample(@Param("record") RentUser record, @Param("example") RentUserExample example);

    int updateByPrimaryKeySelective(RentUser record);

    int updateByPrimaryKey(RentUser record);
}