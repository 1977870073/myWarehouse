package cn.itcast.ssm.mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: zfxxgl
 * @Package: cn.itcast.ssm.mapper
 * @ClassName: RentAppointmentMapperExpand
 * @Description: 预约表拓展操作
 * @Author: zy
 * @CreateDate: 2020/1/18 9:47
 * @Version: 1.0
 */
public interface RentAppointmentMapperExpand {
    /**
     * 获取预约信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> selectInfo(Map<String, Object> map);
    /**
     * 获取预约信息
     * @param map
     * @return
     */
    public List<Map<String, Object>> selectgqInfo(Map<String, Object> map);

    /**
     * 获取预约信息数量
     * @param user
     * @return
     */
    public Integer selectInfoCount(String user);

    /**
     * 获取过期预约信息数量
     * @param user
     * @return
     */
    public Integer selectgqInfoCount(String user);


}
