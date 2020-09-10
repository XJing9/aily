package com.aaa.dao;

import com.aaa.entity.Welfare;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface WelfareDao extends tk.mybatis.mapper.common.Mapper<Welfare> {
    @Select("select * from welfare")
    List<Map<String,Object>> wel_query(Welfare welfare);
    @Insert("insert into welfare (wel_name,wel_state) values (#{wel_name},0)")
    Integer wel_add(Welfare welfare);
    @Update("update welfare set wel_name=#{wel_name},wel_state=#{wel_state} where wel_id=#{wel_id}")
    Integer  wel_update(Welfare welfare);
    @Delete("delete from welfare where wel_id=#{wel_id}")
    Integer wel_delete(Welfare welfare);

    @Select("select w.wel_name\n" +
            "from iss_wef iw\n" +
            "join issue_position ip\n" +
            "on iw.iss_id=ip.iss_id\n" +
            "join welfare w\n" +
            "on w.wel_id=iw.wef_id\n" +
            "where iw.iss_id=#{iss_id}\n")
    List<Map<String,Object>> issWelQuery(Integer iss_id);
}
