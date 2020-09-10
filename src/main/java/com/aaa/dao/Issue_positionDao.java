package com.aaa.dao;

import com.aaa.entity.Issue_position;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface Issue_positionDao extends tk.mybatis.mapper.common.Mapper<Issue_position> {
    /*
    * 职位详细信息
    * */
    @Select("select en.ent_name,en.ent_scale,en.ent_nature,ind.ind_name,en.ent_url,en.ent_scale,a.are_name,iss.*\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a \n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id" +
            " where iss.iss_id=#{iss_id}")
    List<Map<String,Object>> issQuery(Integer iss_id);

    /*邀请面试--查询某企业发布的招聘信息*/
    @Select("select en.ent_id,en.ent_name,en.ent_nature,ind.ind_name,en.ent_url,en.ent_scale,a.are_name,iss.*\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a\n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id\n" +
            "where iss.iss_id=#{iss_id}")
    List<Map<String,Object>> posIdQuery(Integer iss_id);
    /*
    * 企业中心--发布职位
    * */
//    显示企业发布的职位信息
    @Select("select ip.`*` ,p.`*`\n" +
            "from issue_position ip\n" +
            "join position p\n" +
            "on ip.pos_id=p.pos_id\n" +
            "where ip.ent_id=#{ent_id}")
    List<Map<String,Object>> iss_queryPos(Integer ent_id);
//    根据职位id查看详情信息
    @Select("select * from issue_position where iss_id=#{iss_id}")
    List<Map<String,Object>> iss_queryDetailPos(Integer iss_id);
//    添加职位信息
    @Insert("insert into issue_position\n" +
            "(iss_name,ent_id,pos_id,iss_worknature,iss_count,iss_department,iss_education,iss_experience,iss_age\n" +
            ",iss_address,iss_pay,iss_describe,iss_time,iss_phone,iss_linkman,iss_state)\n" +
            "values\n" +
            "(#{iss_name},#{ent_id},#{pos_id},#{iss_worknature},#{iss_count},#{iss_department}," +
            " #{iss_education},#{iss_experience},#{iss_age},#{iss_address},#{iss_pay},#{iss_describe}," +
            " #{iss_time},#{iss_phone},#{iss_linkman},0)")
    Integer iss_insertPos(Issue_position issue_position);
//    删除职位信息
    @Delete("delete from issue_position where iss_id=#{iss_id}")
    Integer iss_deletePos(String iss_id);
//    上架，下架
    @Update("update issue_position set iss_state=#{iss_state} where iss_id=#{iss_id}")
    Integer iss_updateState(@Param("iss_state") Integer iss_state,@Param("iss_id") Integer iss_id);
}
