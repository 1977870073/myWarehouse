package cn.itcast.ssm.service;

import cn.itcast.ssm.po.RentAppointment;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: zfxxgl
 * @Package: cn.itcast.ssm.service
 * @ClassName: AppointmentService
 * @Description: 预约service接口
 * @Author: zy
 * @CreateDate: 2020/1/18 9:10
 * @Version: 1.0
 */
public interface AppointmentService {
    /**
     * 用户预约房源
     * @param user
     * @param uname
     * @param uphone
     * @param utime
     * @param beizhu
     * @param id
     * @return
     * @throws Exception
     */
    public Integer insertInfo(String user, String uname,String uphone, String utime, String beizhu, Integer id)throws  Exception;

    /**
     * 查看预约信息
     * @param user
     * @param page
     * @param limit
     * @return
     */
    public List<Map<String, Object>> selectInfo(String user, Integer page, Integer limit);

    /**
     * 查看预约信息数量
     * @param user
     * @return
     */
    public Integer selectInfoCount(String user);

    /**
     * 查看过期预约信息数量
     * @param user
     * @return
     */
    public Integer selectGQInfoCount(String user);

    /**
     * 查看过期预约信息
     * @param user
     * @param page
     * @param limit
     * @return
     */
    public List<Map<String, Object>> selectGQInfo(String user, Integer page, Integer limit);

    /**
     * 删除预约消息
     * @param id
     * @return
     */
    public Integer deleteInfo(Integer id);
}
