package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentHouseinfoWithBLOBsExpand;
import cn.itcast.ssm.service.HouseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: DetailsReadController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@Controller
@RequestMapping("/detailsRead")
public class DetailsReadController {
    @Autowired
    private HouseInfoService houseInfo;

    @RequestMapping("/init")
    public ModelAndView selectInfo(HttpServletRequest request)throws Exception{
        String id = request.getParameter("id");
        int i = 0;
        if(id==""||id==null){
            i=47;
        }else{
            i=Integer.parseInt(id);
        }
        RentHouseinfoWithBLOBsExpand info = houseInfo.findByPrimaryKey(i);
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //相当 于request的setAttribut，在jsp页面中通过itemsList取数据
        modelAndView.addObject("info", info);
        //指定视图
        modelAndView.setViewName("detailsRead");

        return modelAndView;
    }
}
