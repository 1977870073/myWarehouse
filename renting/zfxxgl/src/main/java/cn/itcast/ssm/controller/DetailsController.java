package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentHouseinfoWithBLOBsExpand;
import cn.itcast.ssm.po.UserCollection;
import cn.itcast.ssm.po.UserCollectionExample;
import cn.itcast.ssm.service.HouseInfoService;
import cn.itcast.ssm.service.UserCollectionService;
import cn.itcast.ssm.utils.Aes;
import cn.itcast.ssm.utils.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>Title: DetailsController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/2
 */
@Controller
@RequestMapping("/details")
public class DetailsController {

    @Autowired
    private HouseInfoService houseInfo;
    @Autowired
    private UserCollectionService collectionService;

    @RequestMapping("/selectInfo")
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
        modelAndView.setViewName("details");

        return modelAndView;
    }

    @RequestMapping("/collectionHouse")
    public @ResponseBody
    String collectionHouse(HttpServletRequest request, UserCollection u) throws Exception {
        HttpSession session = request.getSession();
        String user = null;
        if(session!=null){
            if(session.getAttribute("user")!=null){
                user = session.getAttribute("user").toString();
                user = Aes.aesDecrypt(user,Aes.KEY);
            }else{
                return "nolog";
            }
        }
        UserCollectionExample example = new UserCollectionExample();
        UserCollectionExample.Criteria criteria = example.createCriteria();
        criteria.andHouseEqualTo(u.getHouse());
        criteria.andUserEqualTo(user);
        criteria.andFlagEqualTo(1);
        List<UserCollection> collections = collectionService.selectByExample(example);
        if(collections.size()!=0){
            return "exist";
        }
        int flag = 0;
        u.setUser(user);
        u.setFlag(1);
        u.setDotime(SimpleDateFormatUtil.getDateTime());
        flag = collectionService.insert(u);
        if(flag>0){
            return "success";
        }else{
            return "error";
        }
    }
}
