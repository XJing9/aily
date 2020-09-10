package com.aaa.entity;

import javax.persistence.Id;

public class Language {
    @Id
    private Integer lan_id;
    private String lan_name;
    private String lan_degree;
    private Integer res_id;

    public Integer getLan_id() {
        return lan_id;
    }

    public void setLan_id(Integer lan_id) {
        this.lan_id = lan_id;
    }

    public String getLan_name() {
        return lan_name;
    }

    public void setLan_name(String lan_name) {
        this.lan_name = lan_name;
    }

    public String getLan_degree() {
        return lan_degree;
    }

    public void setLan_degree(String lan_degree) {
        this.lan_degree = lan_degree;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    @Override
    public String toString() {
        return "Language{" +
                "lan_id=" + lan_id +
                ", lan_name='" + lan_name + '\'' +
                ", lan_degree='" + lan_degree + '\'' +
                ", res_id=" + res_id +
                '}';
    }
}
