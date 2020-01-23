package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentNotice;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: RentNoticeService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/15
 */
public interface RentNoticeService {
    /**
     * 插入通知
     * @param notice
     * @return
     * @throws Exception
     */
    public Integer insert(RentNotice notice)throws Exception;

    /**
     * 获取消息
     * @param user
     * @param type 0：房东 1:管理员
     * @return
     */
    public List<Map<String, Object>> getNotice(String user, Integer type)throws Exception;

    /**
     * 是否有新的消息
     * @param user
     * @param type 0：房东 1:管理员
     * @return
     * @throws Exception
     */
    public Integer hasNewNotice(String user, Integer type)throws  Exception;

    /**
     * 修改房东通知状态
     * @param user
     * @param flag
     * @return
     * @throws Exception
     */
    public Integer updateNoticFlagToFD(String user, Integer flag)throws  Exception;

    /**
     * 删除消息
     * @param id
     * @return
     * @throws Exception
     */
    public Integer delNotice(Integer id)throws  Exception;

    /**
     * 删除该用户全部消息
     * @param user
     * @param sendFlag
     * @return
     * @throws Exception
     */
    public Integer delAllNotice(String user, Integer sendFlag)throws  Exception;

    /**
     * 处理预约，成功发送通知
     * @param id 预约订单id
     * @param notic 房东备注
     * @return
     */
    public Integer fdSendSuccessToUser(Integer id, String notic);

    /**
     * 处理预约，失败发送通知
     * @param id 预约订单id
     * @param notic  房东备注
     * @return
     */
    public Integer fdSendErrorToUser(Integer id, String notic);
}
