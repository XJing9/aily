package com.aaa.entity;

public class Interview {
    private Integer ind_id;
    private String int_name;
    private String int_phone;
    private String int_email;
    private String int_reladdress;
    private Integer ent_id;
    private Integer int_state;

    @Override
    public String toString() {
        return "Interview{" +
                "ind_id=" + ind_id +
                ", int_name='" + int_name + '\'' +
                ", int_email='" + int_email + '\'' +
                ", int_reladdress='" + int_reladdress + '\'' +
                ", ent_id=" + ent_id +
                ", int_state=" + int_state +
                '}';
    }

    public String getInt_phone() {
        return int_phone;
    }

    public void setInt_phone(String int_phone) {
        this.int_phone = int_phone;
    }

    public Integer getInd_id() {
        return ind_id;
    }

    public void setInd_id(Integer ind_id) {
        this.ind_id = ind_id;
    }

    public String getInt_name() {
        return int_name;
    }

    public void setInt_name(String int_name) {
        this.int_name = int_name;
    }

    public String getInt_email() {
        return int_email;
    }

    public void setInt_email(String int_email) {
        this.int_email = int_email;
    }

    public String getInt_reladdress() {
        return int_reladdress;
    }

    public void setInt_reladdress(String int_reladdress) {
        this.int_reladdress = int_reladdress;
    }

    public Integer getEnt_id() {
        return ent_id;
    }

    public void setEnt_id(Integer ent_id) {
        this.ent_id = ent_id;
    }

    public Integer getInt_state() {
        return int_state;
    }

    public void setInt_state(Integer int_state) {
        this.int_state = int_state;
    }
}
