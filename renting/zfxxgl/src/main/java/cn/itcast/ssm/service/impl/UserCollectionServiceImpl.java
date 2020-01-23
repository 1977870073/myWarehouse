package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.RentHouseinfoMapper;
import cn.itcast.ssm.mapper.USerCollectionMapperExpand;
import cn.itcast.ssm.mapper.UserCollectionMapper;
import cn.itcast.ssm.po.RentHouseinfo;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;
import cn.itcast.ssm.service.UserCollectionService;
import cn.itcast.ssm.utils.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: UserCollectionServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
public class UserCollectionServiceImpl implements UserCollectionService {
    @Autowired
    private UserCollectionMapper collectionMapper;
    @Autowired
    private USerCollectionMapperExpand uSerCollectionMapperExpand;
    @Autowired
    private RentHouseinfoMapper rentHouseinfoMapper;
    @Override
    public List<UserCollection> selectByExample(UserCollectionExample example) throws Exception {
        return collectionMapper.selectByExample(example);
    }

    @Override
    public int delete(Integer id) throws Exception {
        UserCollection collection = new UserCollection();
        collection.setId(id);
        collection.setFlag(0);
        collection.setDotime(SimpleDateFormatUtil.getDateTime());
        return collectionMapper.updateByPrimaryKey(collection);
    }

    @Override
    public int insert(UserCollection col) throws Exception {
        return collectionMapper.insertSelective(col);
    }

    @Override
    public List<Map<String, Object>> selectCollectionInfo(String user) throws Exception {
        List<Map<String, Object>> rsList = uSerCollectionMapperExpand.getCollectionInfo(user);
        for (Map<String, Object> map: rsList){
            String s = ((String) map.get("picture")).split("[,]")[0];
            if(((String) map.get("picture")).split("[,]").length<=1){
                map.put("picture",s.substring(s.indexOf("[")+1,s.indexOf("]")));
            }else{
                map.put("picture",s.substring(s.indexOf("[")+1));
            }
        }
        return rsList;
    }

    @Override
    public String checkHouse(Integer id) throws Exception {
        RentHouseinfo info = rentHouseinfoMapper.selectByPrimaryKey(id);
        if(info!=null){
            if(info.getFlag()==1){
                return "success";
            }
            return "xiajia";
        }
        return "error";
    }
}
