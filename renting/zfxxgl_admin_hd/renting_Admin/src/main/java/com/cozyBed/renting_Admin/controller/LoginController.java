package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;
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
import java.util.Map;

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

    /**
     * 管理员登陆
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/verification")
    public String verification(HttpServletRequest request, HttpServletResponse response, String username, String password) throws Exception {
        int flag = 0;
        String user = Aes.aesDecrypt(username, Aes.KEY);
        String pass = Aes.aesDecrypt(password, Aes.KEY);
        try {
            RentAdminExample example = new RentAdminExample();
            RentAdminExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user);
            List<RentAdmin> list= adminService.findByExample(example);
            if(list.size()>0){
                if (list.get(0).getPassword().equals(pass)){
                    flag=1;
                    HttpSession session = request.getSession();
                    session.setAttribute("user",username);
                    session.setAttribute("username",list.get(0).getName());
                }else{
                    return "passE";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            return "success";
        }else{
            return "noname";
        }
    }

    /**
     * 房东登陆
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/verificationFD")
    public String verificationFD(HttpServletRequest request, HttpServletResponse response, String username, String password) throws Exception {
        int flag = 0;
        String user = Aes.aesDecrypt(username,Aes.KEY);
        String pass = Aes.aesDecrypt(password,Aes.KEY);
        try {
            RentUserExample example = new RentUserExample();
            RentUserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user);
            criteria.andUsertypeEqualTo("1");
            List<RentUser> list= adminService.selectFDByExample(example);
            if(list.size()>0){
                if (list.get(0).getPassword().equals(pass)){
                    if(list.get(0).getActivation().equals("1")){
                        flag=1;
                        HttpSession session = request.getSession();
                        session.setAttribute("user",username);
                        session.setAttribute("username",list.get(0).getName());
                    }else{
                        return "actiE";
                    }
                }else{
                    return "passE";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            return "success";
        }else{
            return "noname";
        }
    }

    /**
     *注册房东账号
     * @param arg1  用户名
     * @param arg2  密码
     * @param arg3  昵称
     * @param arg4  邮箱
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerFD")
    public String registerFD(String arg1, String arg2, String arg3, String arg4)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String password = Aes.aesDecrypt(arg2,Aes.KEY);
        String name = arg3;
        String email = arg4;
        String result = adminService.registerFD(username,password,name,email);
        return result;
    }

    /**
     * 忘记密码--发送邮箱
     * @param arg1 用户名
     * @param arg2 邮箱
     * @return
     */
    @RequestMapping("/sendMail")
    public String sendMail(String arg1,String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String email = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.sendMail(username,email);
        return result;
    }


    /**
     * 修改密码
     * @param arg1  用户名
     * @param arg2  密码
     * @return
     */
    @RequestMapping("updatePassword")
    public String updatePassword(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String password = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.updatePassword(username,password);
        return result;
    }

    /**
     * 激活房东注册账号
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationZFD")
    public String[] activationZFD(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.activation(0,1,username,code);
        if("success".equals(result)){
            return new String[]{"success","/web/zf/html/login.html","前往登陆页面"};
        }
        return new String[]{"error"};
    }

    /**
     * 房东忘记密码
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationWJFD")
    public String[] activationWJFD(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.activation(1,1,username,code);
        if("success".equals(result)){
            return new String[]{"success","/web/zf/html/update.html?arg1="+username,"前往修改密码"};
        }
        return new String[]{"error"};
    }

    /**
     * 激活用户注册账号
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationZYH")
    public String[] activationZYH(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.activation(0,0,username,code);
        if("success".equals(result)){
            return new String[]{"success","http://localhost:8080/renting/login/init.action","前往登陆页面"};
        }
        return new String[]{"error"};
    }

    /**
     * 房东用户密码
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationWJYH")
    public String[] activationWJYH(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = adminService.activation(1,0,username,code);
        if("success".equals(result)){
            return new String[]{"success","/web/zf/html/update.html?arg1="+arg1,"前往修改密码"};
        }
        return new String[]{"error"};
    }

    /**
     * 退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/invalidate")
    public String  invalidate(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "success";
    }
}
