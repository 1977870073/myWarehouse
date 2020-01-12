package com.cozyBed.renting_Admin.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.mapper
 * @ClassName: RentNoticeMapperExpand
 * @Description: 拓展通知
 * @Author: zy
 * @CreateDate: 2020/1/12 9:32
 * @Version: 1.0
 */
@Repository
public interface RentNoticeMapperExpand {
    /**
     * 查询通知
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectInfo(Map<String, Object> paramMap);

    /**
     * 是否有新的消息
     * @param paramMap
     * @return
     */
    public Integer hasNewNotice(Map<String, Object> paramMap);
}
