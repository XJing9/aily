package com.aaa.entity;

import javax.persistence.Id;
import javax.persistence.Column;
import java.util.List;

public class Industry {
    @Id
    private Integer ind_id;
    @Column
    private String ind_name;
    private Integer ind_state;
    private List<Position> position;

    public List<Position> getPosition() {
        return position;
    }

    public void setPosition(List<Position> position) {
        this.position = position;
    }

    public Integer getInd_id() {
        return ind_id;
    }

    public void setInd_id(Integer ind_id) {
        this.ind_id = ind_id;
    }

    public String getInd_name() {
        return ind_name;
    }

    public void setInd_name(String ind_name) {
        this.ind_name = ind_name;
    }

    public Integer getInd_state() {
        return ind_state;
    }

    public void setInd_state(Integer ind_state) {
        this.ind_state = ind_state;
    }

    @Override
    public String toString() {
        return "Industry{" +
                "ind_id=" + ind_id +
                ", ind_name='" + ind_name + '\'' +
                ", ind_state=" + ind_state +
                ", position=" + position +
                '}';
    }
}
