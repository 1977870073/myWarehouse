package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import com.cozyBed.renting_Admin.service.RentAdminService;
import com.cozyBed.renting_Admin.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>Title: LoginController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RentAdminService adminService;

    @RequestMapping("/verification")
    public String verification(HttpServletRequest request, HttpServletResponse response, String username, String password) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int flag = 0;
//        String user = Aes.aesDecrypt(username, Aes.KEY);
//        String pass = Aes.aesDecrypt(password, Aes.KEY);
        String user = username;
        String pass = password;
        try {
            RentAdminExample example = new RentAdminExample();
            RentAdminExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user);
            criteria.andPasswordEqualTo(pass);
            List<RentAdmin> list= adminService.findByExample(example);
            if(list.size()>0){
                flag=1;
                HttpSession session = request.getSession();
                session.setAttribute("user",username);
                session.setAttribute("username",list.get(0).getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/invalidate")
    public String  invalidate(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "success";
    }
}
