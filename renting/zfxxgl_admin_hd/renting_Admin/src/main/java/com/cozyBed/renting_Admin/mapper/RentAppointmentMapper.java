package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentAppointment;
import com.cozyBed.renting_Admin.po.RentAppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentAppointmentMapper {
    long countByExample(RentAppointmentExample example);

    int deleteByExample(RentAppointmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentAppointment record);

    int insertSelective(RentAppointment record);

    List<RentAppointment> selectByExample(RentAppointmentExample example);

    RentAppointment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentAppointment record, @Param("example") RentAppointmentExample example);

    int updateByExample(@Param("record") RentAppointment record, @Param("example") RentAppointmentExample example);

    int updateByPrimaryKeySelective(RentAppointment record);

    int updateByPrimaryKey(RentAppointment record);
}