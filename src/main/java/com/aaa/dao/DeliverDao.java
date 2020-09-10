package com.aaa.dao;

import com.aaa.entity.Deliver;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface DeliverDao extends tk.mybatis.mapper.common.Mapper<Deliver> {
    /*ְλ����*/
    @Insert("insert into deliver (del_time,res_id,iss_id,del_state)" +
            " values(#{del_time},#{res_id},#{iss_id},1)")
    Integer insertDel(Deliver deliver);
//    ��ҵ�û�--�������루���ܣ����ԣ�
    @Update("update deliver set del_state=#{del_state} where del_id=#{del_id}")
    Integer ent_udpateDelState(@Param("del_state") Integer del_state,@Param("del_id") Integer del_id);

    /*�����û�id��ѯ����id*/
    @Select("select r.res_id from customer c join resume r on c.cus_id=r.cus_id where c.cus_id=#{cus_id}")
    Integer queryRid(Integer cus_id);

    /*��ѯ�ظ�Ͷ������*/
    @Select("select count(del_id) from deliver where res_id=#{res_id} and iss_id=#{iss_id}")
    Integer queryRep(@Param("res_id") Integer res_id, @Param("iss_id") Integer iss_id);
}
