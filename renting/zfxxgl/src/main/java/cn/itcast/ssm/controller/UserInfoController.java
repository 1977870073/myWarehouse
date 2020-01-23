package cn.itcast.ssm.controller;


import cn.itcast.ssm.po.RentUser;
import cn.itcast.ssm.service.RentUserService;
import cn.itcast.ssm.utils.Aes;
import cn.itcast.ssm.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.controller
 * @ClassName: UserController
 * @Description: 用户个人主页
 * @Author: zy
 * @CreateDate: 2020/1/4 11:54
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user/")
public class UserInfoController {
        @Autowired
        private RentUserService rentUserService;

        @RequestMapping("initUserInfo")
        public ModelAndView initUserInfo(HttpServletRequest request) throws Exception{
            ModelAndView model = new ModelAndView();
            model.setViewName("userInfo");
            return model;
        }

        /**
         * 获取用户信息
         * @param request
         * @return
         */
        @RequestMapping("getUsesInfo")
        public @ResponseBody RentUser getUsesInfo(HttpServletRequest request) throws Exception {
            String user = request.getSession().getAttribute("user").toString();
            user = Aes.aesDecrypt(user,Aes.KEY);
            List<RentUser> list= rentUserService.getUserInfo(user, "0");
            if(ObjectUtil.isEmply(list)){
                return null;
            }
            return  list.get(0);
        }

        /**
         * 修改用户信息
         * @param request
         * @param xemail
         * @param xname
         * @return
         */
        @RequestMapping("updateUserIfo")
        public @ResponseBody String updateUserIfo(HttpServletRequest request, String xemail, String xname) throws Exception {
            String user = request.getSession().getAttribute("user").toString();
            user = Aes.aesDecrypt(user,Aes.KEY);
            Integer flag = rentUserService.updateUser(user, "0", xemail, xname);
            if(flag>0){
                request.getSession().setAttribute("username",xname);
                return "success";
            }
            return "error";
        }
}
