package com.cozyBed.renting_Admin.service;

import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;

import java.util.List;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service
 * @ClassName: RentUserService
 * @Description: java类作用描述
 * @Author: zy
 * @CreateDate: 2020/1/4 16:41
 * @Version: 1.0
 */
public interface RentUserService {
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
