package com.aaa.dao;

import com.aaa.entity.Industry;
import com.aaa.entity.Industrys;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface IndustryDao extends tk.mybatis.mapper.common.Mapper<Industry> {
    @Select("select * from industry where indu_id=#{indu_id}")
    List<Industry> Ind_query(Integer indu_id);
    @Insert("insert into industry(ind_name,ind_state)values (#{ind_name},0)")
    Integer Ind_add(Industry industry);
    @Update("update industry set ind_name=#{ind_name} where ind_id=#{ind_id}")
    Integer Ind_update(Industry industry);
    @Delete("delete from industry where ind_id=#{ind_id}")
    Integer Ind_delete(Industry industry);
    @Select("select * from industrys")
    List<Industrys> industrys_queryAll();
}
