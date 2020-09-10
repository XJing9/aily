package com.aaa.entity;

import javax.persistence.Id;

public class Edu_experience {
    @Id
    private Integer edu_id;
    private String edu_education;
    private String edu_schoolname;
    private String edu_majorname;
    private String edu_actiontime;
    private String edu_graduatetime;
    private Integer res_id;

    public String getEdu_education() {
        return edu_education;
    }

    public void setEdu_education(String edu_education) {
        this.edu_education = edu_education;
    }

    public Integer getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(Integer edu_id) {
        this.edu_id = edu_id;
    }

    public String getEdu_schoolname() {
        return edu_schoolname;
    }

    public void setEdu_schoolname(String edu_schoolname) {
        this.edu_schoolname = edu_schoolname;
    }

    public String getEdu_majorname() {
        return edu_majorname;
    }

    public void setEdu_majorname(String edu_majorname) {
        this.edu_majorname = edu_majorname;
    }

    public String getEdu_actiontime() {
        return edu_actiontime;
    }

    public void setEdu_actiontime(String edu_actiontime) {
        this.edu_actiontime = edu_actiontime;
    }

    public String getEdu_graduatetime() {
        return edu_graduatetime;
    }

    public void setEdu_graduatetime(String edu_graduatetime) {
        this.edu_graduatetime = edu_graduatetime;
    }

    public Integer getRes_id() {
        return res_id;
    }

    public void setRes_id(Integer res_id) {
        this.res_id = res_id;
    }

    @Override
    public String toString() {
        return "Edu_experience{" +
                "edu_id=" + edu_id +
                ", edu_schoolname='" + edu_schoolname + '\'' +
                ", edu_majorname='" + edu_majorname + '\'' +
                ", edu_actiontime='" + edu_actiontime + '\'' +
                ", edu_graduatetime='" + edu_graduatetime + '\'' +
                ", res_id=" + res_id +
                '}';
    }
}
