package com.aaa.dao;

import com.aaa.entity.Speciality;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface SpecialityDao extends tk.mybatis.mapper.common.Mapper<Speciality> {
    @Update("update Speciality set spe_name=#{spe_name} where spe_id=#{spe_id}")
    Integer updatespe(Speciality speciality);
    @Delete("delete from Speciality where spe_id=#{spe_id}")
    Integer deletespe(Integer spe_id);
    @Select("select spe_id,spe_name from Speciality where spe_name like CONCAT('%',#{spe_name},'%')")
    List<Speciality>moqueryspe(@Param("spe_name") String spe_name);
    @Select("select s.spe_name\n" +
            "from spe_res sr\n" +
            "join speciality s\n" +
            "on s.spe_id=sr.spe_id\n" +
            "where sr.res_id=#{res_id}")
    List<Map<String,Object>> speQuery(Integer res_id);
}
