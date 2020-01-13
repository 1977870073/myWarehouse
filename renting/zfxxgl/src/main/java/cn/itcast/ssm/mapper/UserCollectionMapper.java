package cn.itcast.ssm.mapper;

import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCollectionMapper {
    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    UserCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}