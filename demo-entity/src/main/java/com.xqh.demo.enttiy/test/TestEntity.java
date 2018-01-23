package com.xqh.demo.enttiy.test;


import java.io.Serializable;
import java.util.Date;


/**
 * Created by xqh on 2017/10/6.
 */
//@XmlRootElement
public class TestEntity implements Serializable {
    private Long id;

    private String desc;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
