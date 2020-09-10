package com.aaa.entity;

import javax.persistence.Id;

public class Customer {
    @Id
    private Integer cus_id;
    private String cus_name;
    private String cus_pwd;
    private String cus_truename;
    private String cus_sex;
    private String cus_birthday;
    private String cus_address;
    private String cus_phone;
    private String cus_registertime;
    private String cus_logintime;
    private String cus_email;
    private String cus_introduce;
    private String cus_state;
    private String cus_workyear;
    private Integer cus_type;
    private Integer ent_id;

    public Integer getCus_type() {
        return cus_type;
    }

    public void setCus_type(Integer cus_type) {
        this.cus_type = cus_type;
    }

    public Integer getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(Integer ent_id) {
        this.ent_id = ent_id;
    }

    public String getCus_workyear() {
        return cus_workyear;
    }

    public void setCus_workyear(String cus_workyear) {
        this.cus_workyear = cus_workyear;
    }

    public Integer getCus_id() {
        return cus_id;
    }

    public void setCus_id(Integer cus_id) {
        this.cus_id = cus_id;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_pwd() {
        return cus_pwd;
    }

    public void setCus_pwd(String cus_pwd) {
        this.cus_pwd = cus_pwd;
    }

    public String getCus_truename() {
        return cus_truename;
    }

    public void setCus_truename(String cus_truename) {
        this.cus_truename = cus_truename;
    }

    public String getCus_sex() {
        return cus_sex;
    }

    public void setCus_sex(String cus_sex) {
        this.cus_sex = cus_sex;
    }

    public String getCus_birthday() {
        return cus_birthday;
    }

    public void setCus_birthday(String cus_birthday) {
        this.cus_birthday = cus_birthday;
    }

    public String getCus_address() {
        return cus_address;
    }

    public void setCus_address(String cus_address) {
        this.cus_address = cus_address;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public String getCus_registertime() {
        return cus_registertime;
    }

    public void setCus_registertime(String cus_registertime) {
        this.cus_registertime = cus_registertime;
    }

    public String getCus_logintime() {
        return cus_logintime;
    }

    public void setCus_logintime(String cus_logintime) {
        this.cus_logintime = cus_logintime;
    }

    public String getCus_email() {
        return cus_email;
    }

    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }


    public String getCus_introduce() {
        return cus_introduce;
    }

    public void setCus_introduce(String cus_introduce) {
        this.cus_introduce = cus_introduce;
    }

    public String getCus_state() {
        return cus_state;
    }

    public void setCus_state(String cus_state) {
        this.cus_state = cus_state;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cus_name='" + cus_name + '\'' +
                ", cus_pwd='" + cus_pwd + '\'' +
                '}';
    }
}
