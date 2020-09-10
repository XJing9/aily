package com.aaa.entity;

import javax.persistence.Id;

public class Welfare {
    @Id
    private Integer wel_id;
    private String wel_name;
    private Integer wel_state;

    public Integer getWel_id() {
        return wel_id;
    }

    public void setWel_id(Integer wel_id) {
        this.wel_id = wel_id;
    }

    public String getWel_name() {
        return wel_name;
    }

    public void setWel_name(String wel_name) {
        this.wel_name = wel_name;
    }

    public Integer getWel_state() {
        return wel_state;
    }

    public void setWel_state(Integer wel_state) {
        this.wel_state = wel_state;
    }

    @Override
    public String toString() {
        return "Welfare{" +
                "wel_id=" + wel_id +
                ", wel_name='" + wel_name + '\'' +
                ", wel_state=" + wel_state +
                '}';
    }
}
