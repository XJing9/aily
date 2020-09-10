package com.aaa.dao;


import com.aaa.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface AreaDao extends tk.mybatis.mapper.common.Mapper<Area>{
    @Select("select * from area where parent_id=0")
    List<Map<String,Object>> queryOne();
    @Select("select * from area where parent_id=#{parent_id}")
    List<Map<String,Object>> queryTwo(Object parent_id);
}
