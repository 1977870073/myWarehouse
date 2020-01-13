package cn.itcast.ssm.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;


/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.utils
 * @ClassName: RedisUtil
 * @Description: 链接redis工具类
 * @Author: zy
 * @CreateDate: 2019/12/20 11:25
 * @Version: 1.0
 */

public class RedisUtil {
    private final static Logger log = LoggerFactory.getLogger(RedisUtil.class);
    private final static String REDIS_HOST = "localhost";
    private static Jedis jedis;

    static {
        log.debug("初始化redis");
        jedis = new Jedis(REDIS_HOST);

        try {
            if("PONG".equals(jedis.ping())){
                log.debug("初始化redis成功！");
            }else{
                log.error("redis初始化失败！");
            throw new Exception("redis初始化失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 在redis中存储一个String类型的数据
     * @param key
     * @param value
     * @return
     */
    public static Boolean setString(String key, String value){
        if(ObjectUtil.isEmply(key)){
            return false;
        }
        String rs = jedis.set(key,value);//赋值
        jedis.expire(key, 300);//设置过期时间，单位：秒
        if(rs.equals("OK")){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取String类型的数据
     * @param key
     * @return
     */
    public static String getString(String key){
        if(ObjectUtil.isEmply(key)){
            return null;
        }
        return jedis.get(key);
    }
}
