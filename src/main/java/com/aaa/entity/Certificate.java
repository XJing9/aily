package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Certificate {
    @Id
    private Integer cer_id;
    private String cer_name;
    private String cer_time;
    private Integer res_id;

    public Integer getCer_id() {
        return cer_id;
    }

    public void setCer_id(Integer cer_id) {
        this.cer_id = cer_id;
    }

    public String getCer_name() {
        return cer_name;
    }

    public void setCer_name(String cer_name) {
        this.cer_name = cer_name;
    }

    public String getCer_time() {
        return cer_time;
    }

    public void setCer_time(String cer_time) {
        this.cer_time = cer_time;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "cer_id=" + cer_id +
                ", cer_name='" + cer_name + '\'' +
                ", cer_time='" + cer_time + '\'' +
                ", res_id=" + res_id +
                '}';
    }
}
