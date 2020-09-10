package com.aaa.entity;

import java.util.List;

public class Industrys {
    private Integer indu_id;
    private String indu_name;
    private List<Industry> industry;

    public List<Industry> getIndustry() {
        return industry;
    }

    public void setIndustry(List<Industry> industry) {
        this.industry = industry;
    }

    public Integer getIndu_id() {
        return indu_id;
    }

    public void setIndu_id(Integer indu_id) {
        this.indu_id = indu_id;
    }

    public String getIndu_name() {
        return indu_name;
    }

    public void setIndu_name(String indu_name) {
        this.indu_name = indu_name;
    }

    @Override
    public String toString() {
        return "Industrys{" +
                "indu_id=" + indu_id +
                ", indu_name='" + indu_name + '\'' +
                ", industry=" + industry +
                '}';
    }
}
