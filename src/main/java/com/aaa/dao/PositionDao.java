package com.aaa.dao;


import com.aaa.entity.Position;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface PositionDao extends tk.mybatis.mapper.common.Mapper<Position> {
    @Select("select p.pos_id,p.pos_name,i.ind_name,p.pos_state from position p join industry i on p.ind_id=i.ind_id where ind_name=#{ind_name}")
    List<Map<String,Object>> pos_query(String ind_name);
    @Insert(value = "insert into position (pos_name,ind_id,pos_state) values (#{pos_name},#{ind_id},0)")
    Integer pos_add(Position position);
    @Update("update position set pos_name=#{pos_name},ind_id=#{ind_id},pos_state=#{pos_state} where pos_id=#{pos_id}")
    Integer pos_update(Position position);
    @Delete("delete from position where pos_id=#{pos_id}")
    Integer pos_delete(Position position);

    @Select("select * from position where ind_id=#{ind_id}")
    public List<Position> position_query(Integer ind_id);
}
