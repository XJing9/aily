package com.aaa.dao;

import com.aaa.entity.Project_experience;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface Pro_experienceDao extends tk.mybatis.mapper.common.Mapper<Project_experience> {
    @Select("select * from project_experience where wor_id=#{wor_id}")
    List<Map<String,Object>> proQuery(Integer wor_id);
}
