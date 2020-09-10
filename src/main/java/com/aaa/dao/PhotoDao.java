package com.aaa.dao;

import com.aaa.entity.Photo;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface PhotoDao extends Mapper<Photo> {
    @Select("select * from photo where pho_state=2")
    List<Map<String,Object>> queryPhoto();
}
