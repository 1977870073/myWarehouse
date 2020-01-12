package com.cozyBed.renting_Admin.controller;

import com.cozyBed.renting_Admin.po.RentNotice;
import com.cozyBed.renting_Admin.service.RentNoticeService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.controller
 * @ClassName: NoteController
 * @Description: 通知相关Controller
 * @Author: zy
 * @CreateDate: 2019/12/29 21:35
 * @Version: 1.0
 */
@RestController
@RequestMapping("/notice/")
public class NoteController {
    @Autowired
    private RentNoticeService rentNoticeService;

    /**
     * 房东有新的消息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("hasNewNote")
    public Integer hasNewNote(HttpServletRequest request)throws  Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Integer result = rentNoticeService.hasNewNotice(user);
        if(result<=0){
            return 0;
        }
        return 1;
    }

    /**
     * 房东有新的消息
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("getData")
    public Map<String, Object> getData(HttpServletRequest request)throws  Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        List< Map<String, Object>> rtmap = rentNoticeService.getNotice(user);
        Integer ff = rentNoticeService.updateNoticFlagToFD(user,0);
        Map<String, Object> map  =new HashMap<>();
        map.put("queryInfo", rtmap);
        return map;
    }

    /**
     * 删除指定id通知
     * @param request
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping("delNotice")
    public Integer delNotice(HttpServletRequest request, Integer id)throws  Exception{
        if (id==0){
            return 0;
        }
        Integer flag = rentNoticeService.delNotice(id);
        return flag;
    }

    /**
     * 删除该用户所有通知
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("delAllNotice")
    public Integer delAllNotice(HttpServletRequest request)throws  Exception{
        String user = request.getSession().getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        Integer flag = rentNoticeService.delAllNotice(user, 1);
        return flag;
    }
}
