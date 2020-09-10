package com.aaa.dao;

import com.aaa.entity.Invited;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface InvitedDao extends tk.mybatis.mapper.common.Mapper<Invited> {
    /*添加面试邀请*/
    @Insert("insert into invited(iss_id,int_id,inv_time,res_id,inv_state)" +
            " values(#{iss_id},#{int_id},#{inv_time},#{res_id},1)")
    Integer insertInv(Invited invited);
    /*重复校验*/
    @Select("select count(inv_id) from invited where iss_id=#{iss_id} and res_id=#{res_id}")
    Integer checkRep(Invited invited);

    /*应聘者个人中心--求职管理(面试邀请)*/
//    显示
    @Select("select iss.iss_name,e.ent_name,i.*\n" +
            "from invited i\n" +
            "join issue_position iss\n" +
            "on i.iss_id=iss.iss_id\n" +
            "join entreprenenur e\n" +
            "on e.ent_id=iss.ent_id\n" +
            "where i.res_id=#{res_id}")
    List<Map<String,Object>> queryInv(Integer res_id);
    //    面试详情显示
    @Select("select i.*,inte.*\n" +
            "from invited i\n" +
            "join interview inte\n" +
            "on i.int_id=inte.int_id\n" +
            "where i.inv_id=#{inv_id}")
    List<Map<String,Object>> inv_queryInter(Integer inv_id);
//    面试邀请处理（接受，忽略）
    @Update("update invited set inv_state=#{inv_state} where inv_id=#{inv_id}")
    Integer inv_updateState( @Param("inv_state") Integer inv_state,@Param("inv_id") Integer inv_id);
    /*根据用户id查询简历id*/
    @Select("select res_id from resume where cus_id=#{cus_id}")
    Integer queryRid(Integer cus_id);

    /*应聘者个人中心--求职管理（已申请职位）*/
    @Select("select ip.iss_name,e.ent_name,d.*\n" +
            "from deliver d\n" +
            "join issue_position ip\n" +
            "on ip.iss_id=d.iss_id\n" +
            "join entreprenenur e\n" +
            "on e.ent_id=ip.ent_id" +
            " where d.res_id=#{res_id}")
    List<Map<String,Object>> queryDel(Integer res_id);
}
