package com.cozyBed.renting_Admin.utils;

import java.util.UUID;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.utils
 * @ClassName: ActivationUtil
 * @Description: 随机生成激活码
 * @Author: zy
 * @CreateDate: 2019/12/20 12:22
 * @Version: 1.0
 */
public class ActivationUtil {
    /**
     * 获取激活码
     * @return
     */
    public static String getActivation(){
        return UUID.randomUUID().toString();
    }
}
