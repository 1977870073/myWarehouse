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
import java.util.Map;

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
        List<Map<String, Object>> collections = userCollectionService.selectCollectionInfo(user);
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        modelAndView.addObject("queryInfo", collections);
        //指定视图
        modelAndView.setViewName("collection");
        return modelAndView;
    }

    @RequestMapping("/checkHouse")
    public @ResponseBody String checkHouse(HttpServletRequest request, Integer id)throws  Exception{
        String result = userCollectionService.checkHouse(id);
        return result;
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
