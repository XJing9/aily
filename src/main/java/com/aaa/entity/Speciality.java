package com.aaa.entity;

public class Speciality {
    private Integer spe_id;
    private String spe_name;

    public Speciality() {
    }

    public Speciality(Integer spe_id, String spe_name) {
        this.spe_id = spe_id;
        this.spe_name = spe_name;
    }

    public Integer getSpe_id() {
        return spe_id;
    }

    public void setSpe_id(Integer spe_id) {
        this.spe_id = spe_id;
    }

    public String getSpe_name() {
        return spe_name;
    }

    public void setSpe_name(String spe_name) {
        this.spe_name = spe_name;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "spe_id=" + spe_id +
                ", spe_name='" + spe_name + '\'' +
                '}';
    }
}
