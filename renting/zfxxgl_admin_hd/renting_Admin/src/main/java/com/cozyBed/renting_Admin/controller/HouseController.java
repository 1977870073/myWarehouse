package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.Page;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: HouseController</p>
 * <p>Description: 房源显示</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/12
 */
@RestController
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseInfoService houseInfo;

    @RequestMapping("/init")
    public String init(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        String index = request.getParameter("index");
        int i = 0;
        if(index==""||index==null){
            i=1;
        }else{
            i=Integer.parseInt(index);
        }
        Page page =  page = new Page(i,40,(int)houseInfo.selectByUserCount(user));
        List<RentHouseinfoWithBLOBs> temp = houseInfo.selectByUser(user,(i-1)*40);
        List<RentHouseinfoWithBLOBs> list = new ArrayList<RentHouseinfoWithBLOBs>();
        for (RentHouseinfoWithBLOBs f:temp){
            String s = f.getPicture().split("[,]")[0];
            if(f.getPicture().split("[,]").length<=1){
                f.setPicture(s.substring(s.indexOf("[")+1,s.indexOf("]")));
            }else{
                f.setPicture(s.substring(s.indexOf("[")+1));
            }
            list.add(f);
        }
        Object[] obj = new Object[]{list, page};
        return JSON.toJSONString(obj);
    }

    @RequestMapping("/deleteInfo")
    public String deleteInfo(HttpServletRequest request, Integer id){
        int flag = 0;
        try {
            flag = houseInfo.deleteByPrimaryKey(id);
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
