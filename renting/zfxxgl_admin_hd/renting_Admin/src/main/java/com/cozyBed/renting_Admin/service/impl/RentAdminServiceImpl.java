package com.cozyBed.renting_Admin.service.impl;

import com.cozyBed.renting_Admin.mapper.RentAdminMapper;
import com.cozyBed.renting_Admin.mapper.RentUserMapper;
import com.cozyBed.renting_Admin.po.RentAdmin;
import com.cozyBed.renting_Admin.po.RentAdminExample;
import com.cozyBed.renting_Admin.po.RentUser;
import com.cozyBed.renting_Admin.po.RentUserExample;
import com.cozyBed.renting_Admin.service.RentAdminService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import com.cozyBed.renting_Admin.utils.RedisUtil;
import com.cozyBed.renting_Admin.utils.mail.PoolSender;
import com.cozyBed.renting_Admin.utils.mail.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>Title: RentAdminServiceImpl</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/11
 */
@Service
public class RentAdminServiceImpl implements RentAdminService {
    @Autowired
    private RentAdminMapper rentAdminMapper;
    @Autowired
    private RentUserMapper rentUserMapper;

    private PoolSender pool = new PoolSender();//发送邮件线程池

    @Override
    public List<RentAdmin> findByExample(RentAdminExample example) throws Exception {
        List<RentAdmin> list = rentAdminMapper.selectByExample(example);
        if(list==null){
            return null;
        }
        return list;
    }

    /**
     * 找到房东账号
     * @param example
     * @return
     * @throws Exception
     */
    public List<RentUser> selectFDByExample(RentUserExample example) throws Exception {
        return rentUserMapper.selectByExample(example);
    }

    /**
     * 注册房东账号
     * @param username
     * @param password
     * @param name
     * @param email
     * @return
     */
    @Override
    public String registerFD(String username, String password, String name, String email)throws Exception  {
        RentUserExample example = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUsertypeEqualTo("1");
        List<RentUser> exit = rentUserMapper.selectByExample(example);
        if(exit.size()>0){
            return "exit";
        }
        RentUser user = new RentUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setEmail(email);
        user.setUsertype("1");
        user.setActivation("0");
        Integer flag = rentUserMapper.insertSelective(user);
        if(flag<=0){
            return "error";
        }
        String code = UUID.randomUUID().toString();
        if(!RedisUtil.setString(code, username)){
            return "error";
        }
        username = Aes.aesEncrypt(username, Aes.KEY);
        code = Aes.aesEncrypt(code, Aes.KEY);
        Sender sender = new Sender(name, username, email, code, 1,0);
        pool.send(sender);
        return "success";
    }

    /**
     * 验证房东账号是否已存在
     * @param username
     * @return
     * @throws Exception
     */
    @Override
    public String FDisExit(String username) throws Exception {
        RentUserExample example = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUsertypeEqualTo("1");
        List<RentUser> exit = rentUserMapper.selectByExample(example);
        if(exit==null||exit.size()<=0){
            return "ok";
        }
        return "exit";
    }

    /**
     * 房东忘记密码发送邮件
     * @param username
     * @param email
     * @return
     */
    @Override
    public String sendMail(String username, String email)throws Exception {
        String code = UUID.randomUUID().toString();
        String userN = Aes.aesEncrypt(username, Aes.KEY);
        String codeEnc = Aes.aesEncrypt(code, Aes.KEY);
        //查询房东信息
        RentUserExample example  = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUsertypeEqualTo("1");
        List<RentUser> userList = rentUserMapper.selectByExample(example);
        if(userList==null||userList.size()<=0){
            return "error";
        }
        if(!userList.get(0).getEmail().equals(email)){
            return "nothisemail";
        }
        String name = userList.get(0).getName();
        Sender sender = new Sender(name, userN, email, codeEnc, 1,1);
        pool.send(sender);
        if(RedisUtil.setString(code, username)){
            return "success";
        }
        return "error";
    }

    /**
     * 修改密码
     * @param username
     * @param password
     * @return
     */
    @Override
    public String updatePassword(String username, String password) {
        RentUserExample example  = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUsertypeEqualTo("1");
        List<RentUser> userList = rentUserMapper.selectByExample(example);//查询当前房东信息，查看状态是否已进行修改验证
        if(userList!=null&&userList.size()>0){
            if(!userList.get(0).getActivation().equals("2")){
                return "error";
            }
        }
        RentUser user = new RentUser();
        user.setId(userList.get(0).getId());
        user.setPassword(password);
        user.setActivation("1");
        Integer flag = rentUserMapper.updateByPrimaryKeySelective(user);
        if(flag>0){
            return "success";
        }
        return "error";
    }

    /**
     * 激活
     * @param type  注册(0)或修改(1)
     * @param userType  房东(1)或用户(0)
     * @param username  用户名
     * @param code  激活码
     * @return
     */
    @Override
    public String activation(Integer type, Integer userType, String username, String code) {
        String value = RedisUtil.getString(code);
        if(ObjectUtil.isEmply(value)){
            return "error";
        }
        RentUserExample example  = new RentUserExample();
        RentUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if(userType==1){
            criteria.andUsertypeEqualTo("1");
        }else{
            criteria.andUsertypeEqualTo("0");
        }
        RentUser user = new RentUser();
        if(type==0){
            user.setActivation("1");
        }else{
            user.setActivation("2");
        }
        Integer flag = rentUserMapper.updateByExampleSelective(user, example);
        List<RentUser> userList = rentUserMapper.selectByExample(example);//查询当前房东信息，查看状态是否已进行修改验证
        if(flag>0){
            return "success";
        }
        return "error";
    }
}
