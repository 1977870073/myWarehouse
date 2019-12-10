package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentNotice;
import com.cozyBed.renting_Admin.po.RentNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RentNoticeMapper {
    long countByExample(RentNoticeExample example);

    int deleteByExample(RentNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RentNotice record);

    int insertSelective(RentNotice record);

    List<RentNotice> selectByExampleWithBLOBs(RentNoticeExample example);

    List<RentNotice> selectByExample(RentNoticeExample example);

    RentNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RentNotice record, @Param("example") RentNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") RentNotice record, @Param("example") RentNoticeExample example);

    int updateByExample(@Param("record") RentNotice record, @Param("example") RentNoticeExample example);

    int updateByPrimaryKeySelective(RentNotice record);

    int updateByPrimaryKeyWithBLOBs(RentNotice record);

    int updateByPrimaryKey(RentNotice record);
}