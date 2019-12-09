package com.cozyBed.renting_Admin.service.impl;

import com.alibaba.fastjson.JSON;
import com.cozyBed.renting_Admin.mapper.RentHouseinfoMapperExpand;
import com.cozyBed.renting_Admin.mapper.UserCollectionMapperExpand;
import com.cozyBed.renting_Admin.service.IndexService;
import com.cozyBed.renting_Admin.utils.SimpleDateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @ProjectName: renting_Admin
 * @Package: com.cozyBed.renting_Admin.service.impl
 * @ClassName: IndexServiceImpl
 * @Description: Index业务层实现方法
 * @Author: zy
 * @CreateDate: 2019/12/6 9:02
 * @Version: 1.0
 */
@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private UserCollectionMapperExpand userCollectionMapperExpand;
    @Autowired
    private RentHouseinfoMapperExpand rentHouseinfoMapperExpand;
    /**
     * 获取echarts图的房源数据
     * @return
     */
    @Override
    public String getEchartsData() {
        Map<String,  List<Long>> rtResult = new HashMap<>();
        List<Long> scList = new ArrayList<>();//收藏数
        List<Long> htList = new ArrayList<>();//后台发布房源数
        List<Long> yhList = new ArrayList<>();//用户发布房源数
        String[] weekDay = new String[7];
        try {
            List<Map<String, Object>> scResult = userCollectionMapperExpand.selectWeekCount();//收藏数
            List<Map<String, Object>> htResult = rentHouseinfoMapperExpand.selectWeekCountForHT();//后台发布
            List<Map<String, Object>> yhResult = rentHouseinfoMapperExpand.selectWeekCountForYH();//用户发布

            //获取日期
            for(int i=0; i<7; i++){
                weekDay[i] = SimpleDateFormatUtil.getOtherDate(-6+i);
            }
            //添加收藏数数据
            for (int k=0; k<weekDay.length; k++){
                Long num = 0L;
                a:for (int j=0; j<scResult.size(); j++){
                    String date = SimpleDateFormatUtil.dataTimeToData((String) scResult.get(j).get("doTime"));
                    num = 0L;
                    if (date.equals(weekDay[k])){
                        num = (Long) scResult.get(j).get("count");
                        break a;
                    }
                }
                scList.add(num);
            }
            //添加后台发布房源数数据
            for (int k=0; k<weekDay.length; k++){
                Long num = 0L;
                a:for (int j=0; j<htResult.size(); j++){
                    String date = SimpleDateFormatUtil.dataTimeToData((String) htResult.get(j).get("doTime"));
                    num = 0L;
                    if (date.equals(weekDay[k])){
                        num = (Long) htResult.get(j).get("count");
                        break a;
                    }
                }
                htList.add(num);
            }
            //添加用户发布房源数数据
            for (int k=0; k<weekDay.length; k++){
                Long num = 0L;
                a:for (int j=0; j<yhResult.size(); j++){
                    String date = SimpleDateFormatUtil.dataTimeToData((String) yhResult.get(j).get("doTime"));
                    num = 0L;
                    if (date.equals(weekDay[k])){
                        num = (Long) yhResult.get(j).get("count");
                        break a;
                    }
                }
                yhList.add(num);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        rtResult.put("sc",scList);
        rtResult.put("ht",htList);
        rtResult.put("yh",yhList);
        return JSON.toJSONString(rtResult);
    }

    /**
     * 获取主页顶部数据数据
     * @return
     */
    @Override
    public List<Integer> getZYData() {
        List<Integer> result = new ArrayList<>();
        try {
            Integer num = userCollectionMapperExpand.selectMonthUserCount();//用户数
            result.add(num);
            num = userCollectionMapperExpand.selectMonthCount();//收藏数
            result.add(num);
            num = rentHouseinfoMapperExpand.selectMonthCountForHT();//后台房源发布数
            result.add(num);
            num = rentHouseinfoMapperExpand.selectMonthCountForYH();//用户房源发布数
            result.add(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
