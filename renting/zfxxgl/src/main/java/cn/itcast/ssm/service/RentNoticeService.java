package cn.itcast.ssm.service;

import cn.itcast.ssm.po.RentNotice;

import java.util.List;

/**
 * <p>Title: RentNoticeService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
public interface RentNoticeService {
    //查询信息
    public List<RentNotice> selectByExampleWithBLOBs(String user)throws Exception;
    //修改信息状态
    public int updateFlag(Integer id)throws Exception;
    //删除信息
    public int deleteNotice(Integer id)throws Exception;
}
