package cn.itcast.ssm.controller;

import cn.itcast.ssm.po.RentUser;
import cn.itcast.ssm.po.RentUserExample;
import cn.itcast.ssm.service.RentUserService;
import cn.itcast.ssm.utils.Aes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private RentUserService userService;

    /**
     * 初始化登陆界面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/init")
    public ModelAndView init(HttpServletRequest request)throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 初始化激活页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/initTips")
    public ModelAndView initTips(HttpServletRequest request)throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("tips");
        return modelAndView;
    }

    /**
     * 初始化忘记密码页面
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/initForger")
    public ModelAndView initForger(HttpServletRequest request)throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("forget");
        return modelAndView;
    }

    /**
     * 初始化修改密码页面
     * @param request
     * @param arg1
     * @return
     * @throws Exception
     */
    @RequestMapping("/initUpdateP")
    public ModelAndView initUpdateP(HttpServletRequest request,String arg1)throws Exception{
        //返回ModelAndView
        ModelAndView modelAndView =  new ModelAndView();
        //指定视图
        modelAndView.setViewName("updateP");
        return modelAndView;
    }
    /**
     * 登陆校验
     * @param request
     * @param response
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    @RequestMapping("/verification")
    public @ResponseBody
    String verification(HttpServletRequest request, HttpServletResponse response, String username, String password) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        int flag = 0;
        String user = Aes.aesDecrypt(username,Aes.KEY);
        String pass = Aes.aesDecrypt(password,Aes.KEY);
        try {
            RentUserExample example = new RentUserExample();
            RentUserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(user);
            criteria.andUsertypeEqualTo("0");
            List<RentUser> list= userService.selectByExample(example);
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
     * 忘记密码--发送邮箱
     * @param arg1 用户名
     * @param arg2 邮箱
     * @return
     */
    @RequestMapping("/sendMail")
    public @ResponseBody String sendMail(String arg1,String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String email = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = userService.sendMail(username,email);
        return result;
    }
    /**
     * 修改密码
     * @param arg1  用户名
     * @param arg2  密码
     * @return
     */
    @RequestMapping("updatePassword")
    public @ResponseBody String updatePassword(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String password = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = userService.updatePassword(username,password);
        return result;
    }
    /**
     * 激活用户注册账号
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationZYH")
    public @ResponseBody String[] activationZYH(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = userService.activation(0,0,username,code);
        if("success".equals(result)){
            return new String[]{"success","/login/init.action","前往登陆页面"};
        }
        return new String[]{"error"};
    }

    /**
     * 用户忘记密码
     * @param arg1  用户
     * @param arg2  激活码
     * @return
     */
    @RequestMapping("/activationWJYH")
    public @ResponseBody String[] activationWJYH(String arg1, String arg2)throws Exception{
        String username = Aes.aesDecrypt(arg1,Aes.KEY);
        String code = Aes.aesDecrypt(arg2,Aes.KEY);
        String result = userService.activation(1,0,username,code);
        if("success".equals(result)){
            return new String[]{"success","/login/initUpdateP.action?arg1="+username,"前往修改密码"};
        }
        return new String[]{"error"};
    }
}
