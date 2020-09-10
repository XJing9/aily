package com.aaa.entity;

import javax.persistence.Id;

public class Resume {
    @Id
    private Integer res_id;
    private String res_education;
    private String res_jobstate;
    private String res_workcategory;
    private String res_industry;
    private String res_job;
    private String res_workaddress;
    private String res_pay;
    private String res_photo;
    private Integer cus_id;
    private String res_time;
    private Integer res_state;

    @Override
    public String toString() {
        return "Resume{" +
                "res_id=" + res_id +
                ", res_education='" + res_education + '\'' +
                ", res_jobstate='" + res_jobstate + '\'' +
                ", res_workcategory='" + res_workcategory + '\'' +
                ", res_industry='" + res_industry + '\'' +
                ", res_job='" + res_job + '\'' +
                ", res_workaddress='" + res_workaddress + '\'' +
                ", res_pay='" + res_pay + '\'' +
                ", res_photo='" + res_photo + '\'' +
                ", cus_id=" + cus_id +
                ", res_state=" + res_state +
                '}';
    }

    public String getRes_time() {
        return res_time;
    }

    public void setRes_time(String res_time) {
        this.res_time = res_time;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getRes_education() {
        return res_education;
    }

    public void setRes_education(String res_education) {
        this.res_education = res_education;
    }

    public String getRes_jobstate() {
        return res_jobstate;
    }

    public void setRes_jobstate(String res_jobstate) {
        this.res_jobstate = res_jobstate;
    }

    public String getRes_workcategory() {
        return res_workcategory;
    }

    public void setRes_workcategory(String res_workcategory) {
        this.res_workcategory = res_workcategory;
    }

    public String getRes_industry() {
        return res_industry;
    }

    public void setRes_industry(String res_industry) {
        this.res_industry = res_industry;
    }

    public String getRes_job() {
        return res_job;
    }

    public void setRes_job(String res_job) {
        this.res_job = res_job;
    }

    public String getRes_workaddress() {
        return res_workaddress;
    }

    public void setRes_workaddress(String res_workaddress) {
        this.res_workaddress = res_workaddress;
    }

    public String getRes_pay() {
        return res_pay;
    }

    public void setRes_pay(String res_pay) {
        this.res_pay = res_pay;
    }

    public String getRes_photo() {
        return res_photo;
    }

    public void setRes_photo(String res_photo) {
        this.res_photo = res_photo;
    }

    public Integer getCus_id() {
        return cus_id;
    }

    public void setCus_id(Integer cus_id) {
        this.cus_id = cus_id;
    }

    public Integer getRes_state() {
        return res_state;
    }

    public void setRes_state(Integer res_state) {
        this.res_state = res_state;
    }
}
