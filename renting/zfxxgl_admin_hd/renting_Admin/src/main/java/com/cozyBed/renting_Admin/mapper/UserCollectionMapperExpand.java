package com.cozyBed.renting_Admin.mapper;

import com.cozyBed.renting_Admin.po.UserCollection;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.mapper
 * @ClassName: UserCollectionMapperExpand
 * @Description: UserCollectionMapper的拓展方法
 * @Author: zy
 * @CreateDate: 2019/12/6 9:30
 * @Version: 1.0
 */
@Repository
public interface UserCollectionMapperExpand {
    /**
     * 获取一周内的收藏数
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> selectWeekCount()throws Exception;

    /**
     * 获取一个月内的收藏数
     * @return
     * @throws Exception
     */
    public Integer selectMonthCount()throws  Exception;

    /**
     * 获取用户总数
     * @return
     * @throws Exception
     */
    public Integer selectMonthUserCount()throws Exception;
}
