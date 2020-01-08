package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentAppointment;
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
import java.util.Map;

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
    public Object[] getAppointmentInfo(HttpServletRequest request,@RequestParam(required = false, defaultValue = "1") Integer page,
                                       @RequestParam(required = false, defaultValue = "10") Integer limit, Integer type) throws Exception {
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        page = (page-1)*10;
        Object[] result = rentAppointmentService.getAppointmentInfo(user, page, limit, type);
        return result;
    }

    /**
     * 获取预约房源信息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("getAppointmentInfoById")
    public Map<String, Object> getAppointmentInfoById(HttpServletRequest request, Integer id) throws Exception {
        Map<String, Object> result = rentAppointmentService.getAppointmentInfoById(id);
        return result;
    }

    @RequestMapping("toYes")
    public String toYes(Integer id, String notice, String time){
        Integer uFlag = rentAppointmentService.updateAppointmentFlag(id, 1, time);
        if(uFlag<=0){
            return "error";
        }
        Integer  nFlag = rentNoticeService.fdSendSuccessToUser(id, notice);
        if(nFlag<=0){
            return "error";
        }
        return "success";
    }

    @RequestMapping("toNo")
    public String toNo(Integer id, String notice){
        Integer uFlag = rentAppointmentService.updateAppointmentFlag(id, 2);
        if(uFlag<=0){
            return "error";
        }
        Integer nFlag = rentNoticeService.fdSendErrorToUser(id, notice);
        if(nFlag<=0){
            return "error";
        }
        return "success";
    }


}
