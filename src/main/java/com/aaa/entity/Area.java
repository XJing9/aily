package com.aaa.entity;

import javax.persistence.Id;

public class Area {
    @Id
    private Integer are_id;
    private String are_name;
    private Integer parent_id;

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public Integer getAre_id() {
        return are_id;
    }

    public void setAre_id(Integer are_id) {
        this.are_id = are_id;
    }

    public String getAre_name() {
        return are_name;
    }

    public void setAre_name(String are_name) {
        this.are_name = are_name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "are_id=" + are_id +
                ", are_name='" + are_name + '\'' +
                '}';
    }
}
