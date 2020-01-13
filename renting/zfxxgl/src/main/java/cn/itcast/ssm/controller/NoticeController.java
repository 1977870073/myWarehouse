package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentNotice;
import cn.itcast.ssm.service.RentNoticeService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        modelAndView.addObject("list",list);
        //指定视图
        modelAndView.setViewName("notice");
        return modelAndView;
    }

    @RequestMapping("/clear")
    public ModelAndView clear(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        List<RentNotice> list = noticeService.selectByExampleWithBLOBs(user);
        for (RentNotice r:list){
            noticeService.deleteNotice(r.getId());
        }
        list = null;
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("list",list);
        //指定视图
        modelAndView.setViewName("notice");
        return modelAndView;
    }
}
