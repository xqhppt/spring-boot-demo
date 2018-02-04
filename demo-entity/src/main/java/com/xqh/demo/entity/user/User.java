package com.xqh.demo.entity.user;

import com.xqh.demo.entity.Base;

import java.io.Serializable;

/**
 * Created by xqh on 2018/2/4.
 */
public class User extends Base implements Serializable {
    private Long id;

    private String name;

    private Byte sex;

    private Byte age;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
