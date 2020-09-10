package com.aaa.dao;


import com.aaa.entity.Work_experience;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Work_experienceDao extends tk.mybatis.mapper.common.Mapper<Work_experience> {
    @Select("select * from work_experience where res_id=#{res_id}")
    List<Map<String,Object>> wor_query(Integer res_id);
    @Insert("insert into work_experience (wor_companyname,wor_workname,wor_action,wor_dimission,wor_workduty,res_id) values (#{wor_companyname},#{wor_workname},#{wor_action},#{wor_dimission},#{wor_workduty},#{res_id})")
    Integer wor_add(Work_experience work_experience);
    @Update("update work_experience set wor_companyname=#{wor_companyname},wor_workname=#{wor_workname},wor_action=#{wor_action},wor_dimission=#{wor_dimission},wor_workduty=#{wor_workduty},res_id=#{res_id} where wor_id=#{wor_id}")
    Integer wor_update(Work_experience work_experience);
    @Delete("delete from work_experience where wor_id=#{wor_id}")
    Integer wor_delete(Work_experience work_experience);
}
