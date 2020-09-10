package com.aaa.dao;

import com.aaa.entity.Language;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface LanguageDao extends tk.mybatis.mapper.common.Mapper<Language> {
    @Select("select * from language where res_id=#{res_id}")
    List<Map<String,Object>> lan_query(Integer res_id);
    /*@Insert("insert into language (lan_name,lan_degree,res_id) values (#{lan_name},#{lan_degree},#{res_id})")*/
    @Insert("insert into language (lan_name,lan_degree,res_id) values (22,22,1)")
    Integer lan_add(Language language);
    /*@Update("update language set lan_name=#{lan_name},lan_degree=#{lan_degree},res_id=#{res_id}")*/
    @Update("update language set lan_name=33,lan_degree=33,res_id=1 where lan_id=2")
    Integer lan_update(Language language);
    /*@Delete("delete from language where lan_id=#{lan_id}")*/
    @Delete("delete from language where lan_id=2")
    Integer lan_delete(Language language);
}
