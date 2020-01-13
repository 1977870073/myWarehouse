package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.mapper.UserCollectionMapper;
import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;
import cn.itcast.ssm.service.UserCollectionService;
import cn.itcast.ssm.utils.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
