package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: UpdateController</p>
 * <p>Description: 修改</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@RestController
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private HouseInfoService houseInfo;

    @RequestMapping("/init")
    public String init(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        int i = 0;
        if(id==""||id==null){
            i=47;
        }else{
            i=Integer.parseInt(id);
        }
        Choose choose = new Choose();
        RentHouseinfoWithBLOBsExpand info = houseInfo.findByPrimaryKey(i);
        String[] renovation = {"豪华装修","精装修","中等装修","简单装修","毛胚房"};
        String[] price_type = {"面议","年付","半年付","押一付一","押一付二","押一付三","押二付一"};

        Object[] obj = new Object[]{info, choose, renovation, price_type};
        return JSON.toJSONString(obj);
    }


    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request, RentHouseinfoWithBLOBs info){
        int flag = 0;
        try {
            flag = houseInfo.updateByPrimaryKeySelective(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            return "success";
        }else{
            return "error";
        }
    }
}
