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
     * 查询房东消息
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectFDInfo(Map<String, Object> paramMap);

    /**
     * 房东是否有新的消息
     * @param paramMap
     * @return
     */
    public Integer FDhasNewNotice(Map<String, Object> paramMap);

    /**
     * 查询管理员消息
     * @param paramMap
     * @return
     */
    public List<Map<String, Object>> selectGLYInfo(Map<String, Object> paramMap);

    /**
     * 管理员是否有新的消息
     * @param paramMap
     * @return
     */
    public Integer GLYhasNewNotice(Map<String, Object> paramMap);
}
