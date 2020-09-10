package com.aaa.dao;

import com.aaa.entity.Edu_experience;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface Edu_experienceDao extends tk.mybatis.mapper.common.Mapper<Edu_experience> {
    @Select("select * from edu_experience where res_id=#{res_id}")
    List<Map<String,Object>> edu_query(Integer res_id);
    @Insert("insert into edu_experience (edu_schoolname,edu_majorname,edu_education,edu_graduatetime,res_id) values (#{edu_schoolname},#{edu_majorname},#{edu_education},#{edu_graduatetime},#{res_id})")
    Integer edu_add(Edu_experience edu_experience);
    @Update("update edu_experience set edu_schoolname=#{edu_schoolname},edu_majorname=#{edu_majorname},edu_education=#{edu_education},edu_graduatetime=#{edu_graduatetime},res_id=#{res_id} where edu_id=#{edu_id}")
    Integer edu_update(Edu_experience edu_experience);
    @Delete("delete from edu_experience where edu_id=#{edu_id}")
    Integer edu_delete(Edu_experience edu_experience);
}
