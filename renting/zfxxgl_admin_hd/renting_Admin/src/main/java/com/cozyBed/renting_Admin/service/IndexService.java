package com.cozyBed.renting_Admin.service;

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
    public String getEchartsData();
}
