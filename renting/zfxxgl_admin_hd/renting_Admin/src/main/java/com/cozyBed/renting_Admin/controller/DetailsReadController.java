package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: DetailsReadController</p>
 * <p>Description:效果显示 </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@RestController
@RequestMapping("/detailsRead")
public class DetailsReadController {
    @Autowired
    private HouseInfoService houseInfoService;

    @RequestMapping("/init")
    public String selectInfo(String bh)throws Exception{
        int i = 0;
        if(bh==""||bh==null){
            return "";
        }else{
            i=Integer.parseInt(bh);
        }
        RentHouseinfoWithBLOBsExpand info = houseInfoService.findByPrimaryKey(i);

        return JSON.toJSONString(info);
    }
}
