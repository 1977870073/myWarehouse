package com.cozyBed.renting_Admin.utils.mail;

import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.utils
 * @ClassName: Sender
 * @Description: 发送邮件工具类
 * @Author: zy
 * @CreateDate: 2019/12/20 12:25
 * @Version: 1.0
 */
public class Sender implements Runnable{
    private final static Logger log = LoggerFactory.getLogger(Sender.class);
    private final static String emailAccount = "1977870073@qq.com";
    private final static String emailPassword = "lutstatyejykdefg";
    private final static String RT_URL = "http://localhost:7049/web/zf/html/other/tips.html";

    private String name;
    private String username;
    private String receiveEmail;
    private String code;
    private Integer userType;
    private Integer type;

    public Sender(String name, String username, String receiveEmail, String code, Integer userType, Integer type){
        this.name = name;
        this.username = username;
        this.receiveEmail = receiveEmail;
        this.code = code;
        this.userType = userType;
        this.type = type;
    }

    /**
     * 发送邮件
     *@param name   用户名
     * @param username     加密后的用户账号
     * @param receiveEmail 用户邮箱
     * @param code         激活码
     * @param userType     用户类型 1：房东，0：用户
     * @param type         操作类型 0：注册，1：忘记密码
     * @return
     */
    public Boolean sendEmail(String name, String username, String receiveEmail, String code, Integer userType, Integer type) {
        if (ObjectUtil.isEmply(name) ||ObjectUtil.isEmply(username) || ObjectUtil.isEmply(receiveEmail) || ObjectUtil.isEmply(code)) {
            log.warn("发送给"+receiveEmail+",信息不全！");
            return false;
        }
        //1. 创建Properties 类用于记录邮箱的一些属性
        Properties props = new Properties();
        // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.transport.protocol", "smtp");
        // 表示SMTP发送邮件，必须进行身份验证
        props.put("mail.smtp.auth", "true");
        //此处填写SMTP服务器
        props.put("mail.smtp.host", "smtp.qq.com");
        //端口号，QQ邮箱端口587
        props.put("mail.smtp.port", "587");

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        // 设置为debug模式, 可以查看详细的发送 log
//        session.setDebug(true);

        try {
            MimeMessage message = createMimeMessage(session, emailAccount, receiveEmail, name, username, code, userType, type);
            Transport transport = session.getTransport();
            transport.connect(emailAccount, emailPassword);

            //发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
            // 关闭连接
            transport.close();
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("发送给"+receiveEmail+",邮件发送失败！");
            return false;
        }
        log.debug("发送给"+receiveEmail+",邮件发送成功！");
        return true;
    }

    /**
     * 发送邮件信息
     * @param session
     * @param sendMail
     * @param receiveMail
     * @param username
     * @param code
     * @param userType
     * @param type
     * @return
     * @throws Exception
     */
    private MimeMessage createMimeMessage(Session session, String sendMail,
                                          String receiveMail, String name, String username, String code, Integer userType, Integer type) throws Exception {
        String content = getMessageContent(name, username, code, userType, type);
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);
        // From: 发件人
        message.setFrom(new InternetAddress(sendMail, "二房东大佬", "UTF-8"));
        // 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, username, "UTF-8"));
        // 邮件主题
        message.setSubject("租房网站账户验证");
        // 邮件正文（可以使用html标签）
        message.setContent(content, "text/html;charset=UTF-8");
        // 设置发件时间
        message.setSentDate(new Date());

        return message;
    }

    private String getMessageContent(String name, String username, String code, Integer userType, Integer type){
        String content = "<html lang='en'><head></head><body><p>" + name + ",您好!</p>";
        String url = RT_URL + "?arg1="+username;
        Integer arg2 = 0;
        if(userType == 1){
            if(type==0){
                arg2=1;
                url+="activationZFD";
                content+="<p>欢迎注册成为租房网站的房东。请点击下边的链接激活账号。</p>";
            }else{
                arg2=2;
                url+="activationWJFD";
                content+="<p>本邮件是修改验证邮件。请点击下边的链接即可进行修改。</p>";
            }
        }else{
            if(type==0){
                arg2=3;
                url+="activationZYH";
                content+="<p>欢迎注册成为租房网站的用户。请点击下边的链接激活账号。</p>";
            }else{
                arg2=4;
                url+="activationWJYH";
                content+="<p>本邮件是修改验证邮件。请点击下边的链接即可进行修改。</p>";
            }
        }
        url+="&arg2="+arg2+"&arg3="+code;
        content+="<a href='"+url+"'>"+url+"</a></body></html>";
        return content;
    }

    public static void main(String[] args) {
        Sender sender = new Sender("su","su", "2449269649@qq.com", "123",0,0);
        new Thread(sender).start();
    }

    @Override
    public void run() {
        sendEmail(name, username, receiveEmail, code, userType, type);
    }
}
