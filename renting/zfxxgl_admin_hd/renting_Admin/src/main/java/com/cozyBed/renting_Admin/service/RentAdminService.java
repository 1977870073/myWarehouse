package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;

import java.util.List;
import java.util.Map;

/**
 * <p>Title: RentAdminService</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
public interface RentAdminService {
    public List<RentAdmin> findByExample(RentAdminExample example)throws Exception;

    /**
     * 找到房东账号
     * @param example
     * @return
     * @throws Exception
     */
    public List<RentUser> selectFDByExample(RentUserExample example) throws Exception;

    /**
     * 注册房东账号
     * @param username
     * @param password
     * @param name
     * @param email
     * @return
     */
    public String registerFD(String username, String password, String name, String email)throws Exception ;

    /**
     * 房东忘记密码发送邮件
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
     * 激活
     * @param type  注册(0)或修改(1)
     * @param userType  房东(1)或用户(0)
     * @param username  用户名
     * @param code  激活码
     * @return
     */
    public String activation(Integer type, Integer userType, String username, String code);
}
