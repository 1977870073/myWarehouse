package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentUser;
import cn.itcast.ssm.service.RentUserService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>Title: RegisterController</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RentUserService userService;

    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request)throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("register");
        return modelAndView;
    }

    /**
     * 判断用户账号是否存在
     * @param arg1
     * @return
     * @throws Exception
     */
    @RequestMapping("/userIsExit")
    public @ResponseBody String userIsExit(String arg1)throws  Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String result = userService.userIsExit(username);
        return result;
    }

    /**
     *注册用户账号
     * @param arg1  用户名
     * @param arg2  密码
     * @param arg3  昵称
     * @param arg4  邮箱
     * @return
     * @throws Exception
     */
    @RequestMapping("/registerUser")
    public @ResponseBody String registerUser(String arg1, String arg2, String arg3, String arg4)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String password = Aes.aesDecrypt(arg2,Aes.KEY);
        String name = arg3;
        String email = arg4;
        String result = userService.registerUser(username,password,name,email);
        return result;
    }

}
