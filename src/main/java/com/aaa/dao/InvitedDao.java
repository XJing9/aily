package com.aaa.dao;

import com.aaa.entity.Invited;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface InvitedDao extends tk.mybatis.mapper.common.Mapper<Invited> {
    /*�����������*/
    @Insert("insert into invited(iss_id,int_id,inv_time,res_id,inv_state)" +
            " values(#{iss_id},#{int_id},#{inv_time},#{res_id},1)")
    Integer insertInv(Invited invited);
    /*�ظ�У��*/
    @Select("select count(inv_id) from invited where iss_id=#{iss_id} and res_id=#{res_id}")
    Integer checkRep(Invited invited);

    /*ӦƸ�߸�������--��ְ����(��������)*/
//    ��ʾ
    @Select("select iss.iss_name,e.ent_name,i.*\n" +
            "from invited i\n" +
            "join issue_position iss\n" +
            "on i.iss_id=iss.iss_id\n" +
            "join entreprenenur e\n" +
            "on e.ent_id=iss.ent_id\n" +
            "where i.res_id=#{res_id}")
    List<Map<String,Object>> queryInv(Integer res_id);
    //    ����������ʾ
    @Select("select i.*,inte.*\n" +
            "from invited i\n" +
            "join interview inte\n" +
            "on i.int_id=inte.int_id\n" +
            "where i.inv_id=#{inv_id}")
    List<Map<String,Object>> inv_queryInter(Integer inv_id);
//    �������봦�����ܣ����ԣ�
    @Update("update invited set inv_state=#{inv_state} where inv_id=#{inv_id}")
    Integer inv_updateState( @Param("inv_state") Integer inv_state,@Param("inv_id") Integer inv_id);
    /*�����û�id��ѯ����id*/
    @Select("select res_id from resume where cus_id=#{cus_id}")
    Integer queryRid(Integer cus_id);

    /*ӦƸ�߸�������--��ְ����������ְλ��*/
    @Select("select ip.iss_name,e.ent_name,d.*\n" +
            "from deliver d\n" +
            "join issue_position ip\n" +
            "on ip.iss_id=d.iss_id\n" +
            "join entreprenenur e\n" +
            "on e.ent_id=ip.ent_id" +
            " where d.res_id=#{res_id}")
    List<Map<String,Object>> queryDel(Integer res_id);
}
