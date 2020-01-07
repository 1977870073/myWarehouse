package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentAppointmentExtends;
import com.cozyBed.renting_Admin.service.RentAppointmentService;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.controller
 * @ClassName: AppointmentController
 * @Description: 预约功能
 * @Author: zy
 * @CreateDate: 2020/1/4 23:40
 * @Version: 1.0
 */
@RestController
@RequestMapping("/appointment/")
public class AppointmentController {
    @Autowired
    private RentAppointmentService rentAppointmentService;
    @Autowired
    private RentNoticeService rentNoticeService;
    /**
     * 获取预约房源信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("getAppointmentInfo")
    public Object[] getAppointmentInfo(HttpServletRequest request,@RequestParam(required = false, defaultValue = "1") Integer page) throws Exception {
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Object[] result = rentAppointmentService.getAppointmentInfo(user, page);
        return result;
    }

    @RequestMapping("updateFlag")
    public String updateFlag(Integer id, Integer flag){
        if(!(flag==1||flag==2)){
            return "error";
        }
        Integer uFlag = rentAppointmentService.updateAppointmentFlag(id, flag);
        if(uFlag<=0){
            return "error";
        }
        Integer nFlag = 0;
        //成功
        if(flag==1){//成功
            nFlag = rentNoticeService.fdSendSuccessToUser(id);
        }else {
            nFlag = rentNoticeService.fdSendErrorToUser(id);
        }
        return "success";
    }


}
