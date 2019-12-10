package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.UserCollection;
import com.cozyBed.renting_Admin.po.UserCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
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