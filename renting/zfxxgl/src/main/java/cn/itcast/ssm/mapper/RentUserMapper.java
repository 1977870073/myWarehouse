package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.RentUser;
import cn.itcast.ssm.po.RentUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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