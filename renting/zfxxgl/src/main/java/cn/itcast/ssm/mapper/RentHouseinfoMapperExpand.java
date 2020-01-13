package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.Choose;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBsExpand;

import java.util.List;

/**
 * <p>Title: RentHouseinfoMapperExpand</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
public interface RentHouseinfoMapperExpand {
    //返回指定位置的40条记录
    public List<RentHouseinfoWithBLOBs> selectInfoes(Choose choose)throws Exception;
    //返回RentHouseinfoWithBLOBsExpand类型的数据,显示房源详细信息
    public RentHouseinfoWithBLOBsExpand findByPrimaryKey(Integer id)throws Exception;
    //返回显示的数据数量
    public long infoCount(Choose choose)throws Exception;
    //返回搜索数据的前40条
    public List<RentHouseinfoWithBLOBs> selectBySearch(String search)throws Exception;
}
