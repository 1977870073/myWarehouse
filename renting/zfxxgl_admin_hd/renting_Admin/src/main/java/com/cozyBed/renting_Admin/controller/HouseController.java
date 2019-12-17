package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.Page;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> init(HttpServletRequest request,@RequestParam(required = false, defaultValue = "1") Integer page) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Page p =  new Page(page,10,(int)houseInfo.selectByUserCount(user));
        List<RentHouseinfoWithBLOBs> temp = houseInfo.selectByUser(user,(page-1)*10);
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
        Map<String, Object> rtMap = new HashMap<>();
        rtMap.put("queryInfo", list);
        rtMap.put("page", p);
        return rtMap;
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
