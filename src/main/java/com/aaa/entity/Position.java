package com.aaa.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Position {
    @Id
    private Integer pos_id;
    private String pos_name;
    @Id
    @Column
    private Integer ind_id;
    @Column
    private String ind_name;
    private Integer pos_state;

    public Integer getPos_id() {
        return pos_id;
    }

    public void setPos_id(Integer pos_id) {
        this.pos_id = pos_id;
    }

    public String getPos_name() {
        return pos_name;
    }

    public void setPos_name(String pos_name) {
        this.pos_name = pos_name;
    }

    public Integer getInd_id() {
        return ind_id;
    }

    public void setInd_id(Integer ind_id) {
        this.ind_id = ind_id;
    }

    public Integer getPos_state() {
        return pos_state;
    }

    public void setPos_state(Integer pos_state) {
        this.pos_state = pos_state;
    }

    public String getInd_name() {
        return ind_name;
    }

    public void setInd_name(String ind_name) {
        this.ind_name = ind_name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pos_id=" + pos_id +
                ", pos_name='" + pos_name + '\'' +
                ", ind_id=" + ind_id +
                ", ind_name='" + ind_name + '\'' +
                ", pos_state=" + pos_state +
                '}';
    }
}
