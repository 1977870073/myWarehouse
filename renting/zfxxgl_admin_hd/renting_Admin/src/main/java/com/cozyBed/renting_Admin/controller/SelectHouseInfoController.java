package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.Page;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String init(HttpServletRequest request)throws Exception{
        String index = request.getParameter("index");
        int i = 0;
        Choose c = new Choose();
        if(ObjectUtil.isEmply(index)){
            i=1;
        }else{
            i=Integer.parseInt(index);
        }
        c.setIndex((i-1)*10);
        Page page =  page = new Page(i,10,(int)houseInfoService.infoCount(c));
        List<RentHouseinfoWithBLOBs> list = houseInfoService.selectInfoes(c);
        Object[] obj = new Object[]{list, page};
        return JSON.toJSONString(list);
    }
}
