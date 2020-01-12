package com.cozyBed.renting_Admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.mapper
 * @ClassName: RentAccessMapper
 * @Description: 访问权限
 * @Author: zy
 * @CreateDate: 2020/1/12 9:25
 * @Version: 1.0
 */
@Repository
public interface RentAccessMapper {
    @Cacheable("hinfo")
    public List<Map<String, Object>> selectInfo(Integer userType);
}
