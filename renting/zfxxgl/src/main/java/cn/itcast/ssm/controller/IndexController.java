package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.Choose;
import cn.itcast.ssm.po.Page;
import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.po.RentNotice;
import cn.itcast.ssm.service.HouseInfoService;
import cn.itcast.ssm.service.RentNoticeService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: IndexController</p>
 * <p>Description:index页面控制器 </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private HouseInfoService houseInfo;
    @Autowired
    private RentNoticeService noticeService;

    @RequestMapping("/queryInfo")
    public ModelAndView queryInfo(HttpServletRequest request,
                             HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String user = null;
        if(session!=null){
            if(session.getAttribute("user")!=null){
                user = session.getAttribute("user").toString();
                user = Aes.aesDecrypt(user,Aes.KEY);
            }
        }
        //获取HttpServletRequest中的页数，区域，价格，户型，方式和朝向
        String index = request.getParameter("index");
        String search = request.getParameter("search");
        String c1 = request.getParameter("c1");
        String c2 = request.getParameter("c2");
        String c3 = request.getParameter("c3");
        String c4 = request.getParameter("c4");
        String c5 = request.getParameter("c5");
        //页数的临时变量
        int i = 0;
        Choose c = new Choose();
        if(index==""||index==null){
            i=1;
        }else{
            i=Integer.parseInt(index);
        }
        c.setIndex(i);
        if(c1!=""&&c1!=null){
            c.setDistrict(c1);
        }
        if (c2!=""&&c2!=null){
            c.setPriceRange(c2);
        }
        if(c3!=""&&c3!=null){
            c.setHouseType(c3);
        }
        if(c4!=""&&c4!=null){
            c.setRentalMode(c4);
        }
        if(c5!=""&&c5!=null){
            c.setOrientation(c5);
        }
        Page page = null;
        List<RentHouseinfoWithBLOBs> temp  =null;

        if(search!=""&&search!=null){
            page = new Page(i,40,40);
            temp = houseInfo.selectBySearch(search);
        }else{
            page = new Page(i,40,(int)houseInfo.infoCount(c)-1);
            temp = houseInfo.selectInfoes(c);
        }
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
        //获取是否有新的消息
        int flag = 0;
        if(user!=null){
            if(!user.isEmpty()){
                List<RentNotice> notic = noticeService.selectByExampleWithBLOBs(user);
                for (RentNotice r:notic){
                    if(r.getFlag()==1){
                        flag=1;
                    }
                }
            }
        }

        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //添加返回数据
        modelAndView.addObject("queryInfo", list);
        modelAndView.addObject("page", page);
        modelAndView.addObject("choose", c);
        modelAndView.addObject("flag", flag);
        //指定视图
        modelAndView.setViewName("index");

        return modelAndView;
    }

    @RequestMapping("/invalidate")
    public ModelAndView invalidate(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
