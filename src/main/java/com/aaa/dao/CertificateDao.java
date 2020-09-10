package com.aaa.dao;

import com.aaa.entity.Certificate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface CertificateDao extends tk.mybatis.mapper.common.Mapper<Certificate> {
    @Select("select * from certificate where res_id=#{res_id}")
    List<Map<String,Object>> cer_query(Integer res_id);
    /*@Insert("insert into certificate (cer_name,cer_time,res_id) values (#{cer_name},#{cer_time},#{res_id})")*/
    @Insert("insert into certificate (cer_name,cer_time,res_id) values (11,11,1)")
    Integer cer_add(Certificate certificate);
    /*@Update("update certificate set cer_name=#{cer_name},cer_time=#{cer_time},res_id=#{res_id} where cer_id=#{cer_id}")*/
    @Update("update certificate set cer_name=22,cer_time=22,res_id=1 where cer_id=2")
    Integer cer_update(Certificate certificate);
   /* @Delete("delete from certificate where cer_id=#{cer_id}")*/
   @Delete("delete from certificate where cer_id=2")
    Integer cer_delete(Certificate certificate);
}
