package cn.itcast.ssm.service;

import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过用户账号获取收藏房源
     * @param user
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> selectCollectionInfo(String user)throws Exception;

    /**
     * 校验房源是否下架
     * @param id
     * @return
     * @throws Exception
     */
    public String checkHouse(Integer id)throws  Exception;
}
