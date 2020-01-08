package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentAppointment;
import com.cozyBed.renting_Admin.po.RentAppointmentExtends;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service
 * @ClassName: RentAppointmentService
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2020/1/4 23:11
 * @Version: 1.0
 */
public interface RentAppointmentService {
    /**
     * 获取预约消息
     * @param user
     * @param page
     * @param limit
     * @param type
     * @return
     */
    public Object[] getAppointmentInfo(String user,Integer page, Integer limit, Integer type);

    /**
     * 通过id获取预约消息
     * @param id
     * @return
     */
    public Map<String, Object> getAppointmentInfoById(Integer id);

    /**
     * 修改预定消息状态
     * @param id
     * @param flag 1：成功，2：失败
     * @return
     */
    public Integer updateAppointmentFlag(Integer id, Integer flag);
    /**
     * 修改预定消息状态
     * @param id
     * @param flag 1：成功，2：失败
     * @return
     */
    public Integer updateAppointmentFlag(Integer id, Integer flag, String time);
}
