package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentHouseinfoWithBLOBs;
import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;
import cn.itcast.ssm.service.HouseInfoService;
import cn.itcast.ssm.service.UserCollectionService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: CollectionController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@Controller
@RequestMapping("/collection")
public class CollectionController {
    @Autowired
    private UserCollectionService userCollectionService;
    @Autowired
    private HouseInfoService houseInfo;

    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        UserCollectionExample example = new UserCollectionExample();
        UserCollectionExample.Criteria criteria = example.createCriteria();
        criteria.andUserEqualTo(user);
        List<UserCollection> collections = userCollectionService.selectByExample(example);
        List<RentHouseinfoWithBLOBs> list = new ArrayList<RentHouseinfoWithBLOBs>();
        for (UserCollection f:collections){
            RentHouseinfoWithBLOBs t = houseInfo.findByPrimaryKeyOther(f.getHouse());
            String s = t.getPicture().split("[,]")[0];
            if(t.getPicture().split("[,]").length<=1){
                t.setPicture(s.substring(s.indexOf("[")+1,s.indexOf("]")));
            }else{
               t.setPicture(s.substring(s.indexOf("[")+1));
            }
            list.add(t);
        }
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("queryInfo", list);
        //指定视图
        modelAndView.setViewName("collection");
        return modelAndView;
    }

    @RequestMapping("/deleteInfo")
    public @ResponseBody
    String deleteInfo(HttpServletRequest request, Integer id){
        int flag = 0;
        try {
            flag = userCollectionService.delete(id);
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
