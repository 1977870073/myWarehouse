package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.RentHouseinfo;
import cn.itcast.ssm.po.RentHouseinfoExample;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RentHouseinfoMapper {
    long countByExample(RentHouseinfoExample example);

    int deleteByExample(RentHouseinfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentHouseinfoWithBLOBs record);

    int insertSelective(RentHouseinfoWithBLOBs record);

    List<RentHouseinfoWithBLOBs> selectByExampleWithBLOBs(RentHouseinfoExample example);

    List<RentHouseinfo> selectByExample(RentHouseinfoExample example);

    RentHouseinfoWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentHouseinfoWithBLOBs record, @Param("example") RentHouseinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") RentHouseinfoWithBLOBs record, @Param("example") RentHouseinfoExample example);

    int updateByExample(@Param("record") RentHouseinfo record, @Param("example") RentHouseinfoExample example);

    int updateByPrimaryKeySelective(RentHouseinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(RentHouseinfoWithBLOBs record);

    int updateByPrimaryKey(RentHouseinfo record);
}