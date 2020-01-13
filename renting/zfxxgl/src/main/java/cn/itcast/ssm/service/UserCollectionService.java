package cn.itcast.ssm.service;

import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;

import java.util.List;

/**
 * <p>Title: UserCollectionService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
public interface UserCollectionService {
    public List<UserCollection> selectByExample(UserCollectionExample example)throws Exception;

    public int delete(Integer id)throws Exception;

    public int insert(UserCollection col)throws Exception;
}
