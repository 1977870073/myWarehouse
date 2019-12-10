package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.Page;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>Title: SelectHouseInfoController</p>
 * <p>Description: 显示待审批信息列表</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@RestController
@RequestMapping("/houseInfo")
public class SelectHouseInfoController {
    @Autowired
    private HouseInfoService houseInfoService;
    @RequestMapping("/init")
    public String init(@RequestParam(required = false, defaultValue = "1") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer limit)throws Exception{
        Choose c = new Choose();
        c.setIndex((page-1)*10);
        c.setLimit(limit);
        Page p =  new Page(page,10,(int)houseInfoService.infoCount(c));
        List<RentHouseinfoWithBLOBsExpand> list = houseInfoService.selectInfoes(c);
        Object[] obj = new Object[]{list, p.getTotalRecord()};
        return JSON.toJSONString(obj);
    }
}
