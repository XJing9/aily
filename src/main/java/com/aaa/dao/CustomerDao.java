package com.aaa.dao;

import com.aaa.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerDao extends tk.mybatis.mapper.common.Mapper<Customer> {
    /*登录*/

    /*判断密码是否正确*/
    @Select("select * from customer where cus_name=#{cus_name} and cus_pwd=#{cus_pwd}")
    List<Map<String, Object>> customer_login(Customer customer);

    /*判断用户名是否存在*/
    @Select("select * from customer where cus_name=#{cus_name}")
    List<Map<String, Object>> queryName(String cus_name);
    /*根据用户名和密码查找用户状态*/

    /*查询用户所有信息*/
    List<Map<String, Object>> queryAllCus(Customer customer);

    /*判断手机号是否存在*/
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Customer> loginPhone(String cus_phone);

    /*查询企业信息*/
    List<Map<String, Object>> queryEnt(Customer customer);

    /*忘记密码--修改密码*/
    @Insert("update customer set cus_pwd=#{cus_pwd} where cus_phone=#{cus_phone}")
    Integer updatePwd(Customer customer);

    /*注册*/

//    企业注册(手机号注册)
    @Insert("insert into customer(cus_name,cus_pwd,cus_phone,cus_type,ent_id)" +
            " values(#{cus_name},#{cus_pwd},#{cus_phone},2,-1)")
    Integer insertEnt(Customer customer);
    /*查询企业信息*/
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Map<String,Object>> queryEntData(String cus_phone);


    /*
    * 用户注册
    * */

//    添加应聘者账户信息
    @Insert("insert into customer(cus_phone,cus_name,cus_pwd,cus_type,cus_state)" +
            " values(#{cus_phone},#{cus_name},#{cus_pwd},1,1)")
    Integer reg_insertCus(Customer customer);
//    查询新添加的账户密码信息
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Map<String,Object>> reg_showCusData(String cus_phone);
//    根据id修改用户信息
    @Update("update customer set cus_truename=#{cus_truename},cus_sex=#{cus_sex}," +
            " cus_birthday=#{cus_birthday},cus_workyear=#{cus_workyear}" +
            " where cus_id=#{cus_id}")
    Integer reg_updateCus(Customer customer);
//    添加简历信息
    @Insert("insert into resume(res_education,res_jobstate,res_workcategory," +
            " res_industry,res_job,res_workaddress,res_pay,res_time,cus_id,res_state)" +
            " values(#{res_education},#{res_jobstate},#{res_workcategory},#{res_industry}," +
            " #{res_job},#{res_workaddress},#{res_pay},#{res_time},#{cus_id},1)")
    Integer reg_insertRes(Resume resume);


    @Select("select * from customer where cus_id=#{cus_id}")
    List<Map<String, Object>> customerByCus_id(Integer cus_id);

    @Select("select c.*,r.*\n" +
            "from customer c\n" +
            "join resume r\n" +
            "on c.cus_id=r.cus_id" +
            " where c.cus_id=#{cus_id}")
    List<Map<String, Object>> cusQuery(Integer cus_id);
    /*
    * 我的简历
    * */
//    修改用户基本信息
    @Update("update customer set cus_truename=#{cus_truename},cus_sex=#{cus_sex},cus_birthday=#{cus_birthday}," +
            " cus_address=#{cus_address},cus_workyear=#{cus_workyear},cus_email=#{cus_email}" +
            " where cus_id=#{cus_id}")
    Integer updateCus(Customer customer);
//    修改求职意向
    @Update("update resume set res_jobstate=#{res_jobstate},res_workcategory=#{res_workcategory},res_industry=#{res_industry}," +
            " res_job=#{res_job},res_workaddress=#{res_workaddress},res_pay=#{res_pay}" +
            " where res_id=#{res_id}")
    Integer res_updateRes(Resume resume);
//    修改自我介绍
    @Update("update customer set cus_introduce=#{cus_introduce} where cus_id=#{cus_id}")
    Integer res_updateIntro(@Param("cus_introduce") String cus_introduce,@Param("cus_id") Integer cus_id);
//    添加教育经历
    @Insert("insert into edu_experience(edu_schoolname,edu_majorname,edu_education" +
            " ,edu_graduatetime,edu_actiontime,res_id)values(#{edu_schoolname},#{edu_majorname},#{edu_education}," +
            " #{edu_graduatetime},#{edu_actiontime},#{res_id})")
    Integer res_insertEdu(Edu_experience edu_experience);
//    删除教育经历
    @Delete("delete from edu_experience where edu_id=#{edu_id}")
    Integer res_deleteEdu(Integer edu_id);
//    根据编号查询数据
    @Select("select * from edu_experience where edu_id=#{edu_id}")
    List<Map<String,Object>> res_queryByIdEdu(Integer edu_id);
//    修改教育经历
    @Update("update edu_experience set edu_schoolname=#{edu_schoolname},edu_majorname=#{edu_majorname}," +
            " edu_education=#{edu_education},edu_graduatetime=#{edu_graduatetime}," +
            " edu_actiontime=#{edu_actiontime}" +
            " where edu_id=#{edu_id}")
    Integer res_updateEdu(Edu_experience edu_experience);
//    添加工作经历
    @Insert("insert into work_experience(wor_companyname,wor_workname,wor_action," +
            " wor_dimission,wor_workduty,res_id)values(#{wor_companyname},#{wor_workname},#{wor_action}," +
            " #{wor_dimission},#{wor_workduty},#{res_id})")
    Integer res_insertWork(Work_experience work_experience);
//    删除工作经历
    @Delete("delete from work_experience where wor_id=#{wor_id}")
    Integer res_deleteWork(Integer wor_id);
//    修改工作经历--显示数据
    @Select("select * from work_experience where wor_id=#{wor_id}")
    List<Map<String,Object>> res_queryByIdWork(Integer wor_id);
//    修改工作经历
    @Update("update work_experience set wor_companyname=#{wor_companyname}," +
            "wor_workname=#{wor_workname},wor_action=#{wor_action}," +
            "wor_dimission=#{wor_dimission},wor_workduty=#{wor_workduty}" +
            " where wor_id=#{wor_id}")
    Integer res_updateWork(Work_experience work_experience);
//    添加项目经历
    @Insert("insert into project_experience(pro_name,pro_role,pro_action,pro_finish,pro_describe,wor_id)" +
            " values(#{pro_name},#{pro_role},#{pro_action},#{pro_finish},#{pro_describe},#{wor_id})")
    Integer res_insertProject(Project_experience project_experience);
//    修改项目经理--查询数据
    @Select("select * from project_experience where pro_id=#{pro_id}")
    List<Map<String,Object>> res_queryByIdProject(Integer pro_id);
    Integer test();


    @Update("update resume set res_education=#{res_education} where res_id=#{res_id}")
    Integer updateRes(Resume resume);
}
