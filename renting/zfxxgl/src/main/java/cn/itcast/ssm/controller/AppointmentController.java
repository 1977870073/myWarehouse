package cn.itcast.ssm.controller;

import cn.itcast.ssm.service.AppointmentService;
import cn.itcast.ssm.service.RentNoticeService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: zfxxgl
 * @Package: cn.itcast.ssm.controller
 * @ClassName: AppointmentController
 * @Description: 预约操作
 * @Author: zy
 * @CreateDate: 2020/1/18 9:05
 * @Version: 1.0
 */
@Controller
@RequestMapping("/appointment/")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping("initYuyue")
    public ModelAndView initYuyue(){
        ModelAndView model = new ModelAndView();
        model.setViewName("yuyue");
        return  model;
    }
    /**
     * 获取未过期预约信息
     * @param request
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping("getyyinfo")
    public @ResponseBody Object[] getyyinfo(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer limit)throws Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        page = (page-1)*limit;
        List<Map<String, Object>> result = appointmentService.selectInfo(user, page, limit);
        Integer count = appointmentService.selectInfoCount(user);
        return  new Object[]{count, result};
    }

    /**
     * 获取过期预约信息
     * @param request
     * @param page
     * @param limit
     * @return
     * @throws Exception
     */
    @RequestMapping("getgqyyinfo")
    public @ResponseBody Object[] getgqyyinfo(HttpServletRequest request, @RequestParam(required = false, defaultValue = "1") Integer page,
                                               @RequestParam(required = false, defaultValue = "10") Integer limit)throws Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        page = (page-1)*limit;
        List<Map<String, Object>> result = appointmentService.selectGQInfo(user, page, limit);
        Integer count = appointmentService.selectGQInfoCount(user);
        return   new Object[]{count, result};
    }

    /**
     * 用户预约房源
     * @param request
     * @param uname
     * @param uphone
     * @param utime
     * @param beizhu
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("addAppointment")
    public @ResponseBody String addAppointment(HttpServletRequest request, String uname,String uphone, String utime, String beizhu, Integer id)throws  Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Integer flag = appointmentService.insertInfo(user,uname,uphone,utime,beizhu,id);
        if(flag<=0){
            return "error";
        }
        return "success";
    }

    /**
     * 删除预约消息
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("deleteAppointment")
    public @ResponseBody String deleteAppointment(Integer id)throws  Exception{
        Integer flag = appointmentService.deleteInfo(id);
        if(flag<=0){
            return "error";
        }
        return "success";
    }
}
