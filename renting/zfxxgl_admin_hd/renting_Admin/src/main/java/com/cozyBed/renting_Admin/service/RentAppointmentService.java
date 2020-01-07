package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentAppointmentExtends;

import java.util.List;

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
     * @return
     */
    public Object[] getAppointmentInfo(String user,Integer page);

    /**
     * 修改预定消息状态
     * @param id
     * @param flag 1：成功，2：失败
     * @return
     */
    public Integer updateAppointmentFlag(Integer id, Integer flag);
}
