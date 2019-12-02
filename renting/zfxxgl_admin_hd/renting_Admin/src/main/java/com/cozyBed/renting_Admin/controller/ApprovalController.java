package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.po.RentNotice;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * <p>Title: ApprovalController</p>
 * <p>Description: 房源审批</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/12
 */
@RestController
@RequestMapping("/approval")
public class ApprovalController {
    @Autowired
    private HouseInfoService houseInfo;
    @Autowired
    private RentNoticeService noticeService;

    @RequestMapping("/selectInfo")
    public String selectInfo(HttpServletRequest request)throws Exception{
        String id = request.getParameter("id");
        int i = 0;
        if(ObjectUtil.isEmply(id)){
            i=47;
        }else{
            i=Integer.parseInt(id);
        }
        RentHouseinfoWithBLOBsExpand info = houseInfo.findByPrimaryKey(i);
        return JSON.toJSONString(info);
    }

    @RequestMapping("/tYes")
    public String tYes(HttpServletRequest request, RentHouseinfoWithBLOBs info) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        int flag = 0;
        info.setFlag(1);
        flag = houseInfo.updateByPrimaryKeySelective(info);
        if(flag>0){
            RentNotice notice = new RentNotice();
            notice.setAdmin(user);
            notice.setUser(info.getUser());
            notice.setMessage("您提交的房源信息审核通过！");
            notice.setFlag(1);
            flag = noticeService.insert(notice);
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/tNo")
    public String tNo(HttpServletRequest request, Integer id, String uu) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        int flag = 0;
        flag = houseInfo.deleteByPrimaryKey(id);
        if(flag>0){
            RentNotice notice = new RentNotice();
            notice.setAdmin(user);
            notice.setUser(uu);
            notice.setMessage("您提交的房源信息没有审核通过，请重新提交审核信息。");
            notice.setFlag(1);
            flag = noticeService.insert(notice);
            return "success";
        }else{
            return "error";
        }
    }
}
