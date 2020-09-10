package com.aaa.dao;

import com.aaa.entity.Customer;
import com.aaa.entity.Entreprenenur;
import com.aaa.entity.Interview;
import com.aaa.entity.Issue_position;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EntrepreneurDao extends tk.mybatis.mapper.common.Mapper<Entreprenenur> {

    /*查询企业id*/
    @Select("select ent_id from entreprenenur \n" +
            "order by ent_id desc\n" +
            "limit 1")
    Integer findEid();

    /*
    * 企业个人中心
    * */

//    企业资料
//    显示
    @Select("select e.`*`,a.are_name,i.ind_name\n" +
            "from entreprenenur e\n" +
            "join area a\n" +
            "on e.are_id=a.are_id\n" +
            "join industry i\n" +
            "on i.ind_id=e.ind_id\n" +
            "where e.ent_id=#{ent_id}")
    List<Map<String,Object>> ent_basicData(Integer ent_id);
//    查询企业福利
    @Select("select w.wel_name\n" +
            "from welfare w\n" +
            "join ent_wel ew\n" +
            "on w.wel_id=ew.wel_id\n" +
            "where ew.ent_id=#{ent_id}")
    List<Map<String,Object>> ent_queryById(Integer ent_id);

//    删除当前企业关联的福利
    @Delete("delete from ent_wel where ent_id=#{ent_id}")
    Integer ent_deleteWel(Integer ent_id);
//    添加企业信息
    @Insert("insert into entreprenenur\n" +
            "(ent_name,ent_abbreviation,ent_nature,ent_scale,are_id,ind_id,ent_capital,\n" +
            " ent_url,ent_intro,ent_introduce)\n" +
            " values\n" +
            " (#{ent_name},#{ent_abbreviation},#{ent_nature},#{ent_scale},#{are_id}," +
            "#{ind_id},#{ent_capital},#{ent_url},#{ent_intro},#{ent_introduce})")
    Integer insertEnt(Entreprenenur entreprenenur);
//    添加企业福利信息
    @Insert("insert into ent_wel(ent_id,wel_id)values(#{ent_id},#{wel_id})")
    Integer ent_insertWel(@Param("ent_id") Integer ent_id,@Param("wel_id") String wel_id);
//    修改
    @Update("update entreprenenur\n" +
            "set ent_name=#{ent_name},ent_abbreviation=#{ent_abbreviation},ent_nature=#{ent_nature},ent_scale=#{ent_scale},\n" +
            "are_id=#{are_id},ind_id=#{ind_id},ent_capital=#{ent_capital},ent_url=#{ent_url},ent_intro=#{ent_intro},ent_introduce=#{ent_introduce}\n" +
            "where ent_id=#{ent_id}")
    Integer ent_update(Entreprenenur entreprenenur);

//    根据用户id查询用户信息
    @Select("select * from customer where cus_id=${cus_id}")
    List<Map<String,Object>> ent_cidFindeid(Integer cus_id);

//    职位管理--面试邀请
    @Select("select inv.*,ip.iss_id,ip.iss_name,ip.ent_id,r.res_id,r.res_job,c.cus_id,c.cus_truename\n" +
            "from invited inv\n" +
            "join issue_position ip\n" +
            "on inv.iss_id=ip.iss_id\n" +
            "join resume r\n" +
            "on r.res_id=inv.res_id\n" +
            "join customer c\n" +
            "on c.cus_id=r.cus_id\n" +
            "where ip.ent_id=#{ent_id}")
    List<Map<String,Object>> ent_invInterview(Integer ent_id);
//    职位管理--申请面试
    @Select("select d.*,r.res_id,r.res_education,c.cus_id,c.cus_name,c.cus_truename,ip.iss_name\n" +
            "from deliver d\n" +
            "join resume r\n" +
            "on d.res_id=r.res_id\n" +
            "join customer c\n" +
            "on c.cus_id=r.cus_id\n" +
            "join issue_position ip\n" +
            "on ip.iss_id=d.iss_id\n" +
            "where ip.ent_id=#{ent_id}")
    List<Map<String,Object>> ent_applyInter(Integer ent_id);
//    职位管理--面试地址管理
//    查询
    @Select("select * from interview\n" +
            "where ent_id=#{ent_id}")
    List<Map<String,Object>> ent_queryAdd(Integer ent_id);
//    删除
    @Delete("delete from interview where int_id=#{int_id}")
    Integer ent_deleteAdd(String int_id);
//    添加
    @Insert("insert into interview\n" +
            "(int_name,int_phone,int_email,int_reladdress,ent_id,int_state)\n" +
            "values\n" +
            "(#{int_name},#{int_phone},#{int_email},#{int_reladdress},#{ent_id},1)")
    Integer ent_insertAdd(Interview interview);

    /*修改用户信息*/
    @Update("update customer set ent_id=#{ent_id} where cus_id=#{cus_id}")
    Integer updateEntId(Customer customer);

    /*查询地址信息*//*
    @Select("select en.ent_id,en.ent_name,en.ent_nature,ind.ind_name,en.ent_url,en.ent_scale,a.are_name,iss.*\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a \n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id")*/
    List<Map<String,Object>> positionQuery(Issue_position issue_position);

    @Select("select count(iss.iss_id)\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a \n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id")
    Integer totalCount();

    @Select("select * from entreprenenur en join area ar on en.are_id=ar.are_id left join industry i on en.ind_id=i.ind_id order by ent_id")
    List<Entreprenenur> queryent();

    @Delete("delete from entreprenenur where ent_id=#{ent_id}")
    Integer deleteent(Integer ent_id);

    @Update("update entreprenenur set ent_name=#{ent_name},ent_abbreviation=#{ent_abbreviation}," +
            "ent_nature=#{ent_nature},ent_scale=#{ent_scale},are_id=#{are_id},ind_id=#{ind_id}," +
            "ent_photo=#{ent_photo},ent_capital=#{ent_capital},ent_url=#{ent_url},ent_intro=#{ent_intro}," +
            "ent_introduce=#{ent_introduce},ent_logintime=#{ent_logintime},ent_license=#{ent_license}," +
            "ent_authentication=#{ent_authentication},ent_state=#{ent_state} where ent_id=#{ent_id}")
    Integer updent(Entreprenenur entreprenenur);

    /*
    * 面试邀请
    * */
//    显示企业招聘信息
    @Select("select en.ent_id,en.ent_name,en.ent_nature,ind.ind_name,en.ent_url,en.ent_scale,a.are_name,iss.*\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a\n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id\n" +
            "where en.ent_id=#{ent_id}")
    List<Map<String,Object>> posQuery(Integer ent_id);

//    根据用户id查询企业id
    @Select("select ent_id from customer where cus_id=#{cus_id}")
    Integer queryEid(Integer cus_id);


    /*显示企业招聘前四条信息*/
    @Select("select en.ent_id,en.ent_name,en.ent_nature,ind.ind_name,en.ent_url,en.ent_scale,a.are_name,iss.*\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a\n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id\n" +
            "where en.ent_id=#{ent_id}" +
            " limit 4")
    List<Map<String,Object>> posQueryLimit(Integer ent_id);


    /*显示企业福利信息*/
    @Select("select we.wel_name\n" +
            "from entreprenenur en\n" +
            "join ent_wel ew\n" +
            "on ew.ent_id=en.ent_id\n" +
            "join welfare we\n" +
            "on we.wel_id=ew.wel_id" +
            " where en.ent_id=#{ent_id}")
    List<Map<String,Object>> welQuery(Integer ent_id);

    /*显示企业信息*/
    @Select("select en.`*`,a.are_name,ind.ind_name\n" +
            "from entreprenenur en\n" +
            "join area a\n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id\n" +
            "where en.ent_id=#{ent_id}")
    List<Map<String,Object>> listQuery(Integer ent_id);

    /*显示企业招聘职位数量*/
    /*@Select("select count(en.ent_id)\n" +
            "from entreprenenur en\n" +
            "join issue_position iss\n" +
            "on en.ent_id=iss.ent_id\n" +
            "join area a\n" +
            "on a.are_id=en.are_id\n" +
            "join industry ind\n" +
            "on ind.ind_id=en.ind_id\n" +
            "where en.ent_id=15")
    List<Map<String,Object>> posQuery(Integer ent_id);*/


    /*@Select("select * from entreprenenur e1 left join Issue_position i1 on e1.ent_id=i1.ent_id where e1.ent_id=#{ent_id}")
    List<Entreprenenur>listissent(Integer ent_id);*/

    @Select("select * from Issue_position i1 left join entreprenenur e1 on i1.ent_id=e1.ent_id where i1.ent_id=#{ent_id}")
    List<Issue_position>listissent2(Integer ent_id);

    //修改企业状态
    @Update("update from entreprenenur set ent_authentication=1 where ent_id=#{ent_id}")
    Integer updzyzt(Entreprenenur entreprenenur);

    //修改状态
    @Update("update from entreprenenur set ent_authentication=0 where ent_id=#{ent_id}")
    Integer updzt(Entreprenenur entreprenenur);
}
