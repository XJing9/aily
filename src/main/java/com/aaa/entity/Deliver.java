package com.aaa.entity;

public class Deliver {
    private Integer del_id;
    private String del_time;
    private Integer res_id;
    private Integer iss_id;
    private Integer del_state;

    @Override
    public String toString() {
        return "Deliver{" +
                "del_id=" + del_id +
                ", del_time='" + del_time + '\'' +
                ", res_id=" + res_id +
                ", iss_id=" + iss_id +
                ", del_state=" + del_state +
                '}';
    }

    public Integer getDel_id() {
        return del_id;
    }

    public void setDel_id(Integer del_id) {
        this.del_id = del_id;
    }

    public String getDel_time() {
        return del_time;
    }

    public void setDel_time(String del_time) {
        this.del_time = del_time;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    public Integer getIss_id() {
        return iss_id;
    }

    public void setIss_id(Integer iss_id) {
        this.iss_id = iss_id;
    }

    public Integer getDel_state() {
        return del_state;
    }

    public void setDel_state(Integer del_state) {
        this.del_state = del_state;
    }
}
