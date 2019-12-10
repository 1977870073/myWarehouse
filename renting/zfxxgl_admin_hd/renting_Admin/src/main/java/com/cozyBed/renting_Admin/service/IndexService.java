package com.cozyBed.renting_Admin.service;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service.impl
 * @ClassName: IndexService
 * @Description: Index页面的业务处理层
 * @Author: zy
 * @CreateDate: 2019/12/5 22:28
 * @Version: 1.0
 */
public interface IndexService {
    /**
     * 获取主页echarts图房源数据
     * @return
     */
    public Map<String,  List<Long>> getEchartsData();

    /**
     * 获取主页顶部数据数据
     * @return
     */
    public List<Integer> getZYData();
}
