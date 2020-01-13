package com.fh.test.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class RoleQuery extends  DataTablePageBean{

    private String name;

    private Integer status; //1代表启用 2代表禁用

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minCreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxCreateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date minUpdateDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maxUpdateDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getMinCreateDate() {
        return minCreateDate;
    }

    public void setMinCreateDate(Date minCreateDate) {
        this.minCreateDate = minCreateDate;
    }

    public Date getMaxCreateDate() {
        return maxCreateDate;
    }

    public void setMaxCreateDate(Date maxCreateDate) {
        this.maxCreateDate = maxCreateDate;
    }

    public Date getMinUpdateDate() {
        return minUpdateDate;
    }

    public void setMinUpdateDate(Date minUpdateDate) {
        this.minUpdateDate = minUpdateDate;
    }

    public Date getMaxUpdateDate() {
        return maxUpdateDate;
    }

    public void setMaxUpdateDate(Date maxUpdateDate) {
        this.maxUpdateDate = maxUpdateDate;
    }
}
