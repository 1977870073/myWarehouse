package com.cozyBed.renting_Admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cozyBed.renting_Admin.po.Choose;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBs;
import com.cozyBed.renting_Admin.po.RentHouseinfoWithBLOBsExpand;
import com.cozyBed.renting_Admin.service.HouseInfoService;
import com.cozyBed.renting_Admin.utils.Aes;
import com.cozyBed.renting_Admin.utils.ObjectUtil;
import com.cozyBed.renting_Admin.utils.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>Title: UpdateController</p>
 * <p>Description: 修改</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/9
 */
@RestController
@RequestMapping("/update")
public class UpdateController {
    @Autowired
    private HouseInfoService houseInfo;

    @RequestMapping("/init")
    public RentHouseinfoWithBLOBsExpand init(HttpServletRequest request,@RequestParam(required = false, defaultValue = "47") Integer id) throws Exception {
        RentHouseinfoWithBLOBsExpand info = houseInfo.findByPrimaryKey(id);
        return info;
    }


    @RequestMapping("/updateInfo")
    public String updateInfo(HttpServletRequest request, RentHouseinfoWithBLOBs info, @RequestParam(required = false) StringBuffer baseData)throws Exception{
        HttpSession session = request.getSession();
        String user = session.getAttribute("user").toString();
        user = Aes.aesDecrypt(user,Aes.KEY);
        if(!ObjectUtil.isEmply(baseData)){
            List<String> list = new ArrayList<String>();
            JSONArray jsonArray = JSON.parseArray(baseData.toString());
            int temp = jsonArray.size();
            for (int i = 0; i < temp; i++) {
                JSONObject js= jsonArray.getJSONObject(i);
                String path =  UUID.randomUUID() + js.getString("name").substring(js.getString("name").lastIndexOf("."));
                System.out.println(Base64ToImage(js.getString("base64").split(",")[1],"G:/rentingImg/picture/"+path));
                list.add(path);
            }
            info.setPicture(list.toString());
        }
        info.setUser(user);
        info.setUserType(0);
        info.setFlag(1);
        info.setDotime(SimpleDateFormatUtil.getDateTime());
        int flag = 0;
        try {
            flag = houseInfo.updateByPrimaryKeySelective(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag>0){
            return "success";
        }else{
            return "error";
        }
    }

    /**
     * base64字符串转换成图片
     *
     * @param imgStr      base64字符串
     * @param imgFilePath 图片存放路径
     * @return
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    public boolean Base64ToImage(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

        if (imgStr.isEmpty()) // 图像数据为空
        {
            return false;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
