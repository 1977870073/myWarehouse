package com.cozyBed.renting_Admin.po;

import java.io.Serializable;

/**
 * <p>Title: Page</p>
 * <p>Description: 分页类</p>
 *
 * @author Chen
 * @version 1.0
 * @date 2019/4/1
 */
public class Page implements Serializable {
    private static final long serialVersionUID = 1L;
    //需初始化
    private int pagNum;// 当前的页数
    private int pageSize;// 每页显示数量，
    private int totalRecord;// 总记录数

    //计算得出
    private int totalPage;// 总页数
    private int start;
    private int end;

    public Page() {
    }

    public Page(int pagNum, int pageSize, int totalRecord) {
        this.pagNum = pagNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        // 计算总页数
        if (totalRecord % pageSize == 0) {
            this.totalPage = totalRecord / pageSize;
        } else {
            this.totalPage = (totalRecord / pageSize) + 1;
        }
        // 确定limit函数的第一个参数的值
        this.start = 1;
        this.end = 4;
        if (totalPage <= 4) {
            this.end = this.totalPage;
        } else {// pagNum=6;start=4;end=8
            this.start = pagNum - 2;
            this.end = pagNum + 2;
        }
        if (start <= 0) {
            this.start = 1;
            this.end = 4;
        }
        // 举个例子：一共有10页，现在就在第10页，那么根据上面的逻辑end=12，错误；则end=this.totalPage;且下面导航栏还是要出现5个，则start=end-5
        if (end > this.totalPage) {
            this.end = totalPage;
            this.start = end - 4;
        }
    }

    public int getPagNum() {
        return pagNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setPagNum(int pagNum) {
        this.pagNum = pagNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
