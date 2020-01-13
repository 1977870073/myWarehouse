package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.RentHouseinfoMapper;
import cn.itcast.ssm.mapper.RentHouseinfoMapperExpand;
import cn.itcast.ssm.po.Choose;
import cn.itcast.ssm.po.RentHouseinfoExample;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBsExpand;
import cn.itcast.ssm.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>Title: HouseInfoServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
public class HouseInfoServiceImpl implements HouseInfoService {
    @Autowired
    private RentHouseinfoMapperExpand houseinfoMapperExpand;
    @Autowired
    private RentHouseinfoMapper houseinfoMapper;

    public List<RentHouseinfoWithBLOBs> selectInfoes(Choose choose) throws Exception {
        return houseinfoMapperExpand.selectInfoes(choose);
    }

    public long infoCount(Choose choose) throws Exception {
        return houseinfoMapperExpand.infoCount(choose);
    }

    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id) throws Exception {
        return houseinfoMapperExpand.findByPrimaryKey(id);
    }

    @Override
    public RentHouseinfoWithBLOBs findByPrimaryKeyOther(Integer id) throws Exception {
        return houseinfoMapper.selectByPrimaryKey(id);
    }

    public List<RentHouseinfoWithBLOBs> selectBySearch(String search) throws Exception {
        return houseinfoMapperExpand.selectBySearch(search);
    }

    public int insertInfo(RentHouseinfoWithBLOBs info) throws Exception {
        return houseinfoMapper.insertSelective(info);
    }

    @Override
    public List<RentHouseinfoWithBLOBs> selectByUser(String user) throws Exception {
        RentHouseinfoExample info = new RentHouseinfoExample();
        RentHouseinfoExample.Criteria criteria = info.createCriteria();
        criteria.andUserEqualTo(user);
        criteria.andUserTypeEqualTo(1);
        return houseinfoMapper.selectByExampleWithBLOBs(info);
    }

    @Override
    public int updateByPrimaryKeySelective(RentHouseinfoWithBLOBs record) throws Exception {
        return houseinfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) throws Exception {
        return houseinfoMapper.deleteByPrimaryKey(id);
    }
}
