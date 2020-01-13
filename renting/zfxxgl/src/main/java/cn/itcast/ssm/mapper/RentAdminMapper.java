package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.RentAdmin;
import cn.itcast.ssm.po.RentAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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