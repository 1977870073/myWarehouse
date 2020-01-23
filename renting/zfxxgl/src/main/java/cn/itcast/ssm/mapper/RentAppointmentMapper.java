package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.RentAppointment;
import cn.itcast.ssm.po.RentAppointmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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