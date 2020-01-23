package cn.itcast.ssm.mapper;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: zfxxgl
 * @Package: cn.itcast.ssm.mapper
 * @ClassName: USerCollectionMapperExpand
 * @Description: 收藏表的拓展类
 * @Author: zy
 * @CreateDate: 2020/1/15 9:12
 * @Version: 1.0
 */
public interface USerCollectionMapperExpand {
    /**
     * 通过用户获取收藏房源信息
     * @param user
     * @return
     * @throws Exception
     */
    public List<Map<String, Object>> getCollectionInfo(String user) throws  Exception;
}
