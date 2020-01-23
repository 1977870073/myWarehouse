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
     * @param notEqualsSendFlag
     * @return
     * @throws Exception
     */
    public Integer delAllNotice(String user, Integer notEqualsSendFlag)throws  Exception;
}
