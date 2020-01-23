package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.RentAppointmentMapper;
import cn.itcast.ssm.mapper.RentAppointmentMapperExpand;
import cn.itcast.ssm.mapper.RentHouseinfoMapper;
import cn.itcast.ssm.po.RentAppointment;
import cn.itcast.ssm.po.RentHouseinfo;
import cn.itcast.ssm.po.RentHouseinfoExample;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: zfxxgl
 * @Package: cn.itcast.ssm.service.impl
 * @ClassName: AppointmentServiceImpl
 * @Description: 预约业务层
 * @Author: zy
 * @CreateDate: 2020/1/18 9:11
 * @Version: 1.0
 */
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private RentHouseinfoMapper rentHouseinfoMapper;
    @Autowired
    private RentAppointmentMapper rentAppointmentMapper;
    @Autowired
    private RentAppointmentMapperExpand rentAppointmentMapperExpand;

    /**
     * 预约房源，房源下架或删除返回-1，未成功插入信息返回0，成功返回1
     * @param user
     * @param uname
     * @param uphone
     * @param utime
     * @param beizhu
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Integer insertInfo(String user, String uname, String uphone, String utime, String beizhu, Integer id) throws Exception {
        RentHouseinfoExample houseExample = new RentHouseinfoExample();
        RentHouseinfoExample.Criteria hc = houseExample.createCriteria();
        hc.andIdEqualTo(id);
        hc.andFlagEqualTo(1);
        List<RentHouseinfo> houseList = rentHouseinfoMapper.selectByExample(houseExample);
        if(houseList==null|| houseList.size()<=0){
            return -1;
        }
        RentAppointment rentAppointment = new RentAppointment();
        rentAppointment.setFd(houseList.get(0).getUser());
        if(houseList.get(0).getUserType()==0){
            rentAppointment.setSendtype(1);
        }else{
            rentAppointment.setSendtype(2);
        }
        rentAppointment.setUser(user);
        rentAppointment.setUname(uname);
        rentAppointment.setUphone(uphone);
        rentAppointment.setUtime(utime);
        rentAppointment.setHouse(id);
        rentAppointment.setBeizhu(beizhu);
        Integer row = rentAppointmentMapper.insertSelective(rentAppointment);
        if(row<=0){
            return 0;
        }
        return 1;
    }
    /**
     * 查看预约信息
     * @param user
     * @return
     */
    @Override
    public List<Map<String, Object>> selectInfo(String user, Integer page, Integer limit) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user",user);
        paramMap.put("page",page);
        paramMap.put("limit",limit);
        return rentAppointmentMapperExpand.selectInfo(paramMap);
    }

    /**
     * 查看预约信息数量
     * @param user
     * @return
     */
    @Override
    public Integer selectInfoCount(String user) {
        return rentAppointmentMapperExpand.selectInfoCount(user);
    }

    /**
     * 查看过期预约信息数量
     * @param user
     * @return
     */
    @Override
    public Integer selectGQInfoCount(String user) {
        return rentAppointmentMapperExpand.selectgqInfoCount(user);
    }

    /**
     * 查看过期预约信息
     * @param user
     * @return
     */
    @Override
    public List<Map<String, Object>> selectGQInfo(String user, Integer page, Integer limit) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user",user);
        paramMap.put("page",page);
        paramMap.put("limit",limit);
        return rentAppointmentMapperExpand.selectgqInfo(paramMap);
    }
    /**
     * 删除预约消息
     * @param id
     * @return
     */
    @Override
    public Integer deleteInfo(Integer id) {
        return rentAppointmentMapper.deleteByPrimaryKey(id);
    }
}
