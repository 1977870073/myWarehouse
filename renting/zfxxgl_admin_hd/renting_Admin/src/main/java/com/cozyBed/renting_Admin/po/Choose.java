package com.cozyBed.renting_Admin.po;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Choose</p>
 * <p>Description: </p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/3
 */
public class Choose {
   //分别对应首页的五个筛选条件
   private List<String> c1 = new ArrayList<String>();
   private List<String> c2 = new ArrayList<String>();
   private List<String> c3 = new ArrayList<String>();
   private List<String> c4 = new ArrayList<String>();
   private List<String> c5 = new ArrayList<String>();

   private int index;//页数
   private int limit;//一页显示多少数据
   private String district;//区域
   private String priceRange;//价格区间
   private int minPrice;//最低价
   private int maxPrice;//最高价
   private String houseType;//房屋类型
   private String rentalMode;//租房方式
   private String orientation;//朝向

   public int getLimit() {
      return limit;
   }

   public void setLimit(int limit) {
      this.limit = limit;
   }

   public void setIndex(int index) {
      this.index = index;
   }

   public void setDistrict(String district) {
      this.district = district;
   }

   public void setPriceRange(String priceRange) {
      this.priceRange = priceRange;
   }

   public void setMinPrice(int minPrice) {
      this.minPrice = minPrice;
   }

   public void setMaxPrice(int maxPrice) {
      this.maxPrice = maxPrice;
   }

   public void setHouseType(String houseType) {
      this.houseType = houseType;
   }

   public void setRentalMode(String rentalMode) {
      this.rentalMode = rentalMode;
   }

   public void setOrientation(String orientation) {
      this.orientation = orientation;
   }

   public int getIndex() {
      return index;
   }

   public String getDistrict() {
      if(district.equals("不限")||district.equals("")){
         return null;
      }
      return district;
   }

   public String getPriceRange() {
      if(priceRange.equals("不限")||priceRange.equals("")){
         return "";
      }
      return priceRange;
   }

   public int getMinPrice() {
      String t[] = {"不限","500员以下","500-1000元","100-2000元","2000-3000元","3000-5000元","5000-8000元","8000元以上"};
      if(getPriceRange().equals(t[0])||getPriceRange().equals(t[1])){
         return 0;
      }
      else if(getPriceRange().equals(t[2])){
         return 500;
      }
      else if(getPriceRange().equals(t[3])){
         return 1000;
      }
      else if(getPriceRange().equals(t[4])){
         return 2000;
      }
      else if(getPriceRange().equals(t[5])){
         return 3000;
      }
      else if(getPriceRange().equals(t[6])){
         return 5000;
      }else if(getPriceRange().equals(t[7])){
         return 8000;
      }else{
         return 0;
      }
   }

   public int getMaxPrice() {
      String t[] = {"不限","500元以下","500-1000元","100-2000元","2000-3000元","3000-5000元","5000-8000元","8000元以上"};
      if(getPriceRange().equals(t[0])){
         return 0;
      }
      else if(getPriceRange().equals(t[1])){
         return 500;
      }
      else if(getPriceRange().equals(t[2])){
         return 1000;
      }
      else if(getPriceRange().equals(t[3])){
         return 2000;
      }
      else if(getPriceRange().equals(t[4])){
         return 3000;
      }
      else if(getPriceRange().equals(t[5])){
         return 5000;
      }
      else if(getPriceRange().equals(t[6])){
         return 8000;
      }
      else{
         return 0;
      }
   }

   public String getHouseType() {
      if(houseType.equals("不限")||houseType.equals("")){
         return null;
      }
      return houseType;
   }

   public String getRentalMode() {
      if(rentalMode.equals("不限")||rentalMode.equals("")){
         return null;
      }
      return rentalMode;
   }

   public String getOrientation() {
      if(orientation.equals("不限")||orientation.equals("")){
         return null;
      }
      return orientation;
   }

   public List<String> getC1() {
      return c1;
   }

   public List<String> getC2() {
      return c2;
   }

   public List<String> getC3() {
      return c3;
   }

   public List<String> getC4() {
      return c4;
   }

   public List<String> getC5() {
      return c5;
   }

   public Choose(){
      setDistrict("");
      setPriceRange("");
      setOrientation("");
      setRentalMode("");
      setHouseType("");
      String temp1[] = {"天河","番禺","海珠","白云","越秀","花都","增城","荔湾","黄埔","南沙","从化","其它"};
      String temp2[] = {"500元以下","500-1000元","100-2000元","2000-3000元","3000-5000元","5000-8000元","8000元以上"};
      String temp3[] = {"一居","二居","三居","四居","其它"};
      String temp4[] = {"整租","合租"};
      String temp5[] = {"东南","东北","西南","西北","南","北","东","西"};

      for (int i = 0; i < temp1.length; i++) {
         c1.add(temp1[i]);
      }
      for (int i = 0; i < temp2.length; i++) {
         c2.add(temp2[i]);
      }
      for (int i = 0; i < temp3.length; i++) {
         c3.add(temp3[i]);
      }
      for (int i = 0; i < temp4.length; i++) {
         c4.add(temp4[i]);
      }
      for (int i = 0; i < temp5.length; i++) {
         c5.add(temp5[i]);
      }
   }
}
