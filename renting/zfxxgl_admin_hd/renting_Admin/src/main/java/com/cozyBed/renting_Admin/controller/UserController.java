package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.service.RentUserService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.controller
 * @ClassName: UserController
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2020/1/4 11:54
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user/")
public class UserController {
        @Autowired
        private RentUserService  rentUserService;

    /**
     * 获取房东信息
     * @param request
     * @return
     */
    @RequestMapping("getUsesInfo")
        public RentUser getUsesInfo(HttpServletRequest request) throws Exception {
            String user = request.getSession().getAttribute("user").toString();
            user = Aes.aesDecrypt(user,Aes.KEY);
            String type = request.getSession().getAttribute("type").toString();
            if(type.equals("cc0111")){
                type="1";
            }
            List<RentUser>  list= rentUserService.getUserInfo(user, type);
            if(ObjectUtil.isEmply(list)){
                return null;
            }
            return  list.get(0);
        }

    /**
     * 修改房东信息
     * @param request
     * @param xemail
     * @param xname
     * @return
     */
        @RequestMapping("updateUserIfo")
        public String updateUserIfo(HttpServletRequest request, String xemail, String xname) throws Exception {
            String user = request.getSession().getAttribute("user").toString();
            user = Aes.aesDecrypt(user,Aes.KEY);
            String type = request.getSession().getAttribute("type").toString();
            if(type.equals("cc0111")){
                type="1";
            }
            Integer flag = rentUserService.updateUser(user, type, xemail, xname);
            if(flag>0){
                return "success";
            }
            return "error";
        }

}
