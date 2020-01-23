package cn.itcast.ssm.service;

import cn.itcast.ssm.po.RentUser;
import cn.itcast.ssm.po.RentUserExample;

import java.util.List;

/**
 * <p>Title: RentUserService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/3/30
 */
public interface RentUserService {

    public List<RentUser> selectByExample(RentUserExample example)throws  Exception;
    /**
     * 注册用户账号
     * @param username
     * @param password
     * @param name
     * @param email
     * @return
     */
    public String registerUser(String username, String password, String name, String email)throws Exception ;

    /**
     * 验证用户账号是否已存在
     * @param username
     * @return
     * @throws Exception
     */
    public String userIsExit(String username)throws  Exception;

    /**
     * 激活
     * @param type  注册(0)或修改(1)
     * @param userType  房东(1)或用户(0)
     * @param username  用户名
     * @param code  激活码
     * @return
     */
    public String activation(Integer type, Integer userType, String username, String code);

    /**
     * 用户忘记密码发送邮件
     * @param username
     * @param email
     * @return
     */
    public String sendMail(String username,String email)throws Exception;


    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    public String updatePassword(String username, String password);

    /**
     * 获取用户信息
     * @param user
     * @param type
     * @return
     */
    public List<RentUser> getUserInfo(String user, String type);

    /**
     * 修改用户邮箱、昵称
     * @param email
     * @param name
     * @return
     */
    public Integer updateUser(String user, String type, String email, String name);

}
