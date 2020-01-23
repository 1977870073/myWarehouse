package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentNotice;
import cn.itcast.ssm.service.RentNoticeService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>Title: NoticeController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
    @Autowired
    private RentNoticeService noticeService;

    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        List<RentNotice> list = noticeService.selectByExampleWithBLOBs(user);
        for (RentNotice r:list){
            noticeService.updateFlag(r.getId());
        }
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("queryInfo",list);
        //指定视图
        modelAndView.setViewName("notice");
        return modelAndView;
    }


    /**
     * 删除指定id通知
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("/delNotice")
    public @ResponseBody String delNotice(HttpServletRequest request, Integer id)throws  Exception{
        if (id==0){
            return "error";
        }
        Integer flag = noticeService.delNotice(id);
        if(flag>0){
            return "success";
        }
        return "error";
    }

    /**
     * 删除该用户所有通知
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/delAllNotice")
    public @ResponseBody String delAllNotice(HttpServletRequest request)throws  Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Integer flag = noticeService.delAllNotice(user, 1);
        if(flag>0){
            return "success";
        }
        return "error";
    }
}
