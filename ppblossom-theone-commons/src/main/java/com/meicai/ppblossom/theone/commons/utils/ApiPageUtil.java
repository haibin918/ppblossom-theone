package com.meicai.ppblossom.theone.commons.utils;

import java.io.Serializable;
import java.util.List;

public class ApiPageUtil<T> implements Serializable {

    //第几页
    private int page;
    //一页数量
    private int perPage;
    //总数量
    private int total;
    //总页数
    private int totalPage;
    //数据
    private List<T> list;

    public ApiPageUtil(int page, int perPage, int total, int totalPage) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPage = totalPage;
    }

    public ApiPageUtil(int page, int perPage, int total, int totalPage, List<T> list) {
        this.page = page;
        this.perPage = perPage;
        this.total = total;
        this.totalPage = totalPage;
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
