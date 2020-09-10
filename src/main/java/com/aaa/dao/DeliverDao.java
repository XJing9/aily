package com.aaa.dao;

import com.aaa.entity.Deliver;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliverDao extends tk.mybatis.mapper.common.Mapper<Deliver> {
    /*职位申请*/
    @Insert("insert into deliver (del_time,res_id,iss_id,del_state)" +
            " values(#{del_time},#{res_id},#{iss_id},1)")
    Integer insertDel(Deliver deliver);
//    企业用户--面试申请（接受，忽略）
    @Update("update deliver set del_state=#{del_state} where del_id=#{del_id}")
    Integer ent_udpateDelState(@Param("del_state") Integer del_state,@Param("del_id") Integer del_id);

    /*根据用户id查询简历id*/
    @Select("select r.res_id from customer c join resume r on c.cus_id=r.cus_id where c.cus_id=#{cus_id}")
    Integer queryRid(Integer cus_id);

    /*查询重复投递数据*/
    @Select("select count(del_id) from deliver where res_id=#{res_id} and iss_id=#{iss_id}")
    Integer queryRep(@Param("res_id") Integer res_id, @Param("iss_id") Integer iss_id);
}
