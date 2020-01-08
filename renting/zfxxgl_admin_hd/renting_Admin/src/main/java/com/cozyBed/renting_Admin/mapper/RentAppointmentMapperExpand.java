package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.RentAppointment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.mapper
 * @ClassName: RentAppointmentMapperExpand
 * @Description: 预约信息拓展mapper
 * @Author: zy
 * @CreateDate: 2020/1/8 16:10
 * @Version: 1.0
 */
@Repository
public interface RentAppointmentMapperExpand {
    /**
     * 获取预约信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> selectInfo(Map<String, Object> map);
    /**
     * 获取指定id预约信息
     * @param map
     * @return
     */
    public Map<String, Object> selectInfoById(Map<String, Object> map);

    /**
     * 获取预约信息数量
     * @param map
     * @return
     */
    public Integer selectInfoCount(Map<String, Object> map);
}
