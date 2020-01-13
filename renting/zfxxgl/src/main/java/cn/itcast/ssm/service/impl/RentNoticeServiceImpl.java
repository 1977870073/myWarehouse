package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.RentNoticeMapper;
import cn.itcast.ssm.po.RentNotice;
import cn.itcast.ssm.po.RentNoticeExample;
import cn.itcast.ssm.service.RentNoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: RentNoticeServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
public class RentNoticeServiceImpl implements RentNoticeService {
    @Autowired
    private RentNoticeMapper rentNoticeMapper;

    @Override
    public List<RentNotice> selectByExampleWithBLOBs(String user) throws Exception {
        RentNoticeExample example = new RentNoticeExample();
        RentNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        return rentNoticeMapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int updateFlag(Integer id) throws Exception {
        RentNotice notice = new RentNotice();
        notice.setId(id);
        notice.setFlag(0);
        return rentNoticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int deleteNotice(Integer id) throws Exception {
        return rentNoticeMapper.deleteByPrimaryKey(id);
    }
}
