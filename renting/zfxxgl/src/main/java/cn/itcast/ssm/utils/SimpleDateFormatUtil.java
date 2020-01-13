package cn.itcast.ssm.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: renting
 * @Package: cn.itcast.ssm.utils
 * @ClassName: SimpleDateFormatUtil
 * @Description: 获取时间的工具类
 * @Author: zy
 * @CreateDate: 2019/12/5 9:31
 * @Version: 1.0
 */
public class SimpleDateFormatUtil {
    /**
     * 获取时间
     * @return
     */
    public static String getDateTime(){
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(new Date());
    }
}
