package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentAppointmentMapper;
import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapper;
import com.cozyBed.renting_Admin.mapper.RentNoticeMapper;
import com.cozyBed.renting_Admin.po.*;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * <p>Title: RentNoticeServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/15
 */
@Service
public class RentNoticeServiceImpl implements RentNoticeService {
    private final static Logger log = LoggerFactory.getLogger(RentNoticeServiceImpl.class);
    @Autowired
    private RentNoticeMapper noticeMapper;
    @Autowired
    private RentAppointmentMapper rentAppointmentMapper;
    @Autowired
    private RentHouseinfoMapper rentHouseinfoMapper;

    /**
     * 插入通知
     * @param notice
     * @return
     * @throws Exception
     */
    @Override
    public Integer insert(RentNotice notice) throws Exception {
        return noticeMapper.insertSelective(notice);
    }
    /**
     * 是否有新的消息
     * @param user
     * @return
     */
    @Override
    public List<RentNotice> getNotice(String user, Integer flag)throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        if(flag!=0){
            criteria.andFlagEqualTo(flag);
        }
        criteria.andUserEqualTo(user);
        criteria.andSendflagEqualTo(1);
        return noticeMapper.selectByExampleWithBLOBs(example);
    }

    /**
     * 修改房东通知状态
     * @param user
     * @param flag
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateNoticFlagToFD(String user, Integer flag) throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andSendflagEqualTo(1);
        RentNotice notice = new RentNotice();
        notice.setFlag(flag);
        return noticeMapper.updateByExampleSelective(notice, example);
    }

    @Override
    public Integer delNotice(Integer id) throws Exception {
        return noticeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer delAllNotice(String user, Integer sendFlag) throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andSendflagEqualTo(sendFlag);
        return noticeMapper.deleteByExample(example);
    }

    @Override
    public Integer fdSendSuccessToUser(Integer id) {
        RentAppointment rentAppointment = rentAppointmentMapper.selectByPrimaryKey(id);
        if(rentAppointment==null){
            log.error("方法fdSendSuccessToUser--》id:"+id+",获取预约信息失败！");
            return 0;
        }
        RentHouseinfoWithBLOBs rentHouseinfo = rentHouseinfoMapper.selectByPrimaryKey(rentAppointment.getHouse());
        if(rentHouseinfo==null){
            log.error("id:"+id+",获取房源信息失败！");
            return null;
        }
        String fy = getFangyuan(rentAppointment.getHouse());
        String dTime = getTime();
        String muban = "预约成功！<br />预约房源："+fy+"<br />预约时间："+rentAppointment.getUtime()+"<br />" +
                "联系人："+rentHouseinfo.getUserName()+"<br />联系电话："+rentHouseinfo.getUserPhone();
        RentNotice rentNotice = new RentNotice();
        rentNotice.setAdmin(rentAppointment.getFd());
        rentNotice.setUser(rentAppointment.getUser());
        rentNotice.setMessage(muban);
        rentNotice.setFlag(1);
        rentNotice.setSendflag(3);
        rentNotice.setDotime(dTime);
        return noticeMapper.insertSelective(rentNotice);
    }

    @Override
    public Integer fdSendErrorToUser(Integer id) {
        RentAppointment rentAppointment = rentAppointmentMapper.selectByPrimaryKey(id);
        if(rentAppointment==null){
            log.error("方法fdSendErrorToUser--》id:"+id+",获取预约信息失败！");
            return 0;
        }
        String fy = getFangyuan(rentAppointment.getHouse());
        String dTime = getTime();
        RentNotice rentNotice = new RentNotice();
        rentNotice.setAdmin(rentAppointment.getFd());
        rentNotice.setUser(rentAppointment.getUser());
        rentNotice.setMessage("预约失败！<br />预约房源:"+fy);
        rentNotice.setFlag(1);
        rentNotice.setSendflag(3);
        rentNotice.setDotime(dTime);
        return noticeMapper.insertSelective(rentNotice);
    }


    public String getFangyuan(Integer id){
        RentHouseinfoWithBLOBs rentHouseinfo = rentHouseinfoMapper.selectByPrimaryKey(id);
        if(rentHouseinfo==null){
            log.error("id:"+id+",获取房源信息失败！");
            return null;
        }
        String title =  rentHouseinfo.getTitle();
        return "<a href='http://localhost:8080/renting/details/selectInfo.action?id="+id+"'>"+rentHouseinfo.getTitle()+"</a>";
    }

    public String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(new Date());
    }
}
