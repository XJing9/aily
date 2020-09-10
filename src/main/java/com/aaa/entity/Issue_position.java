package com.aaa.entity;
//职位表
public class Issue_position {
    private Integer iss_id;
    private String iss_name;
    private Integer ent_id;
    private String iss_worknature;
    private Integer iss_count;
    private String iss_department;
    private String iss_education;
    private String iss_experience;
    private String iss_age;
    private String iss_address;
    private String iss_describe;
    private Integer iss_state;
    private String iss_time;
    private Integer pos_id;
    private String iss_pay;
    private String iss_linkman;
    private String iss_phone;

    public String getIss_linkman() {
        return iss_linkman;
    }

    public void setIss_linkman(String iss_linkman) {
        this.iss_linkman = iss_linkman;
    }

    public String getIss_phone() {
        return iss_phone;
    }

    public void setIss_phone(String iss_phone) {
        this.iss_phone = iss_phone;
    }

    public String getIss_pay() {
        return iss_pay;
    }

    public void setIss_pay(String iss_pay) {
        this.iss_pay = iss_pay;
    }

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getIss_time() {
        return iss_time;
    }

    public void setIss_time(String iss_time) {
        this.iss_time = iss_time;
    }

    public Issue_position() {
    }

    public Issue_position(Integer iss_id, String iss_name, Integer ent_id, String iss_worknature, Integer iss_count, String iss_department, String iss_education, String iss_experience, String iss_age, String iss_address, String iss_describe, Integer iss_state) {
        this.iss_id = iss_id;
        this.iss_name = iss_name;
        this.ent_id = ent_id;
        this.iss_worknature = iss_worknature;
        this.iss_count = iss_count;
        this.iss_department = iss_department;
        this.iss_education = iss_education;
        this.iss_experience = iss_experience;
        this.iss_age = iss_age;
        this.iss_address = iss_address;
        this.iss_describe = iss_describe;
        this.iss_state = iss_state;
    }

    public Integer getIss_id() {
        return iss_id;
    }

    public void setIss_id(Integer iss_id) {
        this.iss_id = iss_id;
    }

    public String getIss_name() {
        return iss_name;
    }

    public void setIss_name(String iss_name) {
        this.iss_name = iss_name;
    }

    public Integer getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(Integer ent_id) {
        this.ent_id = ent_id;
    }

    public String getIss_worknature() {
        return iss_worknature;
    }

    public void setIss_worknature(String iss_worknature) {
        this.iss_worknature = iss_worknature;
    }

    public Integer getIss_count() {
        return iss_count;
    }

    public void setIss_count(Integer iss_count) {
        this.iss_count = iss_count;
    }

    public String getIss_department() {
        return iss_department;
    }

    public void setIss_department(String iss_department) {
        this.iss_department = iss_department;
    }

    public String getIss_education() {
        return iss_education;
    }

    public void setIss_education(String iss_education) {
        this.iss_education = iss_education;
    }

    public String getIss_experience() {
        return iss_experience;
    }

    public void setIss_experience(String iss_experience) {
        this.iss_experience = iss_experience;
    }

    public String getIss_age() {
        return iss_age;
    }

    public void setIss_age(String iss_age) {
        this.iss_age = iss_age;
    }

    public String getIss_address() {
        return iss_address;
    }

    public void setIss_address(String iss_address) {
        this.iss_address = iss_address;
    }

    public String getIss_describe() {
        return iss_describe;
    }

    public void setIss_describe(String iss_describe) {
        this.iss_describe = iss_describe;
    }

    public Integer getIss_state() {
        return iss_state;
    }

    public void setIss_state(Integer iss_state) {
        this.iss_state = iss_state;
    }

    @Override
    public String toString() {
        return "Issue_position{" +
                "iss_id=" + iss_id +
                ", iss_name='" + iss_name + '\'' +
                ", ent_id=" + ent_id +
                ", iss_worknature='" + iss_worknature + '\'' +
                ", iss_count=" + iss_count +
                ", iss_department='" + iss_department + '\'' +
                ", iss_education='" + iss_education + '\'' +
                ", iss_experience='" + iss_experience + '\'' +
                ", iss_age='" + iss_age + '\'' +
                ", iss_address='" + iss_address + '\'' +
                ", iss_describe='" + iss_describe + '\'' +
                ", iss_state=" + iss_state +
                '}';
    }
}
