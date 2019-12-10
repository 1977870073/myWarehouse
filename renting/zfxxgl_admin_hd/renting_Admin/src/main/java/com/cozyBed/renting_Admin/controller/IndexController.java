package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.controller
 * @ClassName: IndexController
 * @Description: 主页面事件
 * @Author: zy
 * @CreateDate: 2019/12/5 22:10
 * @Version: 1.0
 */
@RestController
@RequestMapping("/index/")
public class IndexController {
    @Autowired
    private IndexService indexServiceImpl;

    @RequestMapping("getEchartsData")
    public Map<String,  List<Long>> getEchartsData(){
        Map<String,  List<Long>> result = indexServiceImpl.getEchartsData();
        return result;
    }

    @RequestMapping("getZYData")
    public List<Integer> getZYData(){
        List<Integer> result = indexServiceImpl.getZYData();
        return result;
    }
}
