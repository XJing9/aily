package com.aaa.dao;

import com.aaa.entity.Interview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface InterviewDao extends tk.mybatis.mapper.common.Mapper<Interview> {
    /*��ѯĬ�ϵ�ַ*/
    @Select("select * from interview where ent_id=#{ent_id} and int_state=2")
    List<Map<String,Object>> queryIn_m(Integer ent_id);
    /*��ѯ���е�ַ*/
    @Select("select * from interview where ent_id=#{ent_id}")
    List<Map<String,Object>> queryIn_a(Integer ent_id);

    /*����int_id���ҵ�ַ��Ϣ*/
    @Select("select * from interview where int_id=#{int_id}")
    List<Map<String,Object>> queryAdd(Integer int_id);
}
