package com.aaa.util;

import java.util.List;
import java.util.Map;

public class PageHelpers {
    //当前页
    private Integer pageNum=1;
    //    每页多少条
    private Integer pageSize = 5;
    //    尾页
    private Integer lastPage;
    //上一页
    private Integer prePage;
    //下一页
    private Integer nextPage;

    public Integer getPrePage() {
        return prePage=this.pageNum-1;
    }

    public void setPrePage(Integer prePage) {
        this.prePage = prePage;
    }

    public Integer getNextPage() {
        return nextPage=this.pageNum+1;
    }

    public void setNextPage(Integer nextPage) {
        this.nextPage = nextPage;
    }

    //   每页的数据
    private List<Map<String,Object>> rows;
    private int totalCount;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public String toString() {
        return "PageHelpers{" +
                "rows=" + rows +
                '}';
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLastPage() {
        return lastPage;
    }

    public void setLastPage(Integer lastPage) {
        this.lastPage = lastPage;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, Object>> rows) {
        this.rows = rows;
    }
}