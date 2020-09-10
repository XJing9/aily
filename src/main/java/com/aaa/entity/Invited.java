package com.aaa.entity;

public class Invited {
    private Integer inv_id;
    private Integer iss_id;
    private Integer int_id;
    private String inv_time;
    private Integer res_id;
    private String inv_state;

    @Override
    public String toString() {
        return "Invited{" +
                "inv_id=" + inv_id +
                ", iss_id=" + iss_id +
                ", int_id=" + int_id +
                ", inv_time='" + inv_time + '\'' +
                ", res_id=" + res_id +
                ", inv_state='" + inv_state + '\'' +
                '}';
    }

    public Integer getInv_id() {
        return inv_id;
    }

    public void setInv_id(Integer inv_id) {
        this.inv_id = inv_id;
    }

    public Integer getIss_id() {
        return iss_id;
    }

    public void setIss_id(Integer iss_id) {
        this.iss_id = iss_id;
    }

    public Integer getInt_id() {
        return int_id;
    }

    public void setInt_id(Integer int_id) {
        this.int_id = int_id;
    }

    public String getInv_time() {
        return inv_time;
    }

    public void setInv_time(String inv_time) {
        this.inv_time = inv_time;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public String getInv_state() {
        return inv_state;
    }

    public void setInv_state(String inv_state) {
        this.inv_state = inv_state;
    }
}
