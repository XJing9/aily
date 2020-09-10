package com.aaa.dao;

import com.aaa.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface CustomerDao extends tk.mybatis.mapper.common.Mapper<Customer> {
    /*��¼*/

    /*�ж������Ƿ���ȷ*/
    @Select("select * from customer where cus_name=#{cus_name} and cus_pwd=#{cus_pwd}")
    List<Map<String, Object>> customer_login(Customer customer);

    /*�ж��û����Ƿ����*/
    @Select("select * from customer where cus_name=#{cus_name}")
    List<Map<String, Object>> queryName(String cus_name);
    /*�����û�������������û�״̬*/

    /*��ѯ�û�������Ϣ*/
    List<Map<String, Object>> queryAllCus(Customer customer);

    /*�ж��ֻ����Ƿ����*/
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Customer> loginPhone(String cus_phone);

    /*��ѯ��ҵ��Ϣ*/
    List<Map<String, Object>> queryEnt(Customer customer);

    /*��������--�޸�����*/
    @Insert("update customer set cus_pwd=#{cus_pwd} where cus_phone=#{cus_phone}")
    Integer updatePwd(Customer customer);

    /*ע��*/

//    ��ҵע��(�ֻ���ע��)
    @Insert("insert into customer(cus_name,cus_pwd,cus_phone,cus_type,ent_id)" +
            " values(#{cus_name},#{cus_pwd},#{cus_phone},2,-1)")
    Integer insertEnt(Customer customer);
    /*��ѯ��ҵ��Ϣ*/
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Map<String,Object>> queryEntData(String cus_phone);


    /*
    * �û�ע��
    * */

//    ���ӦƸ���˻���Ϣ
    @Insert("insert into customer(cus_phone,cus_name,cus_pwd,cus_type,cus_state)" +
            " values(#{cus_phone},#{cus_name},#{cus_pwd},1,1)")
    Integer reg_insertCus(Customer customer);
//    ��ѯ����ӵ��˻�������Ϣ
    @Select("select * from customer where cus_phone=#{cus_phone}")
    List<Map<String,Object>> reg_showCusData(String cus_phone);
//    ����id�޸��û���Ϣ
    @Update("update customer set cus_truename=#{cus_truename},cus_sex=#{cus_sex}," +
            " cus_birthday=#{cus_birthday},cus_workyear=#{cus_workyear}" +
            " where cus_id=#{cus_id}")
    Integer reg_updateCus(Customer customer);
//    ��Ӽ�����Ϣ
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
    * �ҵļ���
    * */
//    �޸��û�������Ϣ
    @Update("update customer set cus_truename=#{cus_truename},cus_sex=#{cus_sex},cus_birthday=#{cus_birthday}," +
            " cus_address=#{cus_address},cus_workyear=#{cus_workyear},cus_email=#{cus_email}" +
            " where cus_id=#{cus_id}")
    Integer updateCus(Customer customer);
//    �޸���ְ����
    @Update("update resume set res_jobstate=#{res_jobstate},res_workcategory=#{res_workcategory},res_industry=#{res_industry}," +
            " res_job=#{res_job},res_workaddress=#{res_workaddress},res_pay=#{res_pay}" +
            " where res_id=#{res_id}")
    Integer res_updateRes(Resume resume);
//    �޸����ҽ���
    @Update("update customer set cus_introduce=#{cus_introduce} where cus_id=#{cus_id}")
    Integer res_updateIntro(@Param("cus_introduce") String cus_introduce,@Param("cus_id") Integer cus_id);
//    ��ӽ�������
    @Insert("insert into edu_experience(edu_schoolname,edu_majorname,edu_education" +
            " ,edu_graduatetime,edu_actiontime,res_id)values(#{edu_schoolname},#{edu_majorname},#{edu_education}," +
            " #{edu_graduatetime},#{edu_actiontime},#{res_id})")
    Integer res_insertEdu(Edu_experience edu_experience);
//    ɾ����������
    @Delete("delete from edu_experience where edu_id=#{edu_id}")
    Integer res_deleteEdu(Integer edu_id);
//    ���ݱ�Ų�ѯ����
    @Select("select * from edu_experience where edu_id=#{edu_id}")
    List<Map<String,Object>> res_queryByIdEdu(Integer edu_id);
//    �޸Ľ�������
    @Update("update edu_experience set edu_schoolname=#{edu_schoolname},edu_majorname=#{edu_majorname}," +
            " edu_education=#{edu_education},edu_graduatetime=#{edu_graduatetime}," +
            " edu_actiontime=#{edu_actiontime}" +
            " where edu_id=#{edu_id}")
    Integer res_updateEdu(Edu_experience edu_experience);
//    ��ӹ�������
    @Insert("insert into work_experience(wor_companyname,wor_workname,wor_action," +
            " wor_dimission,wor_workduty,res_id)values(#{wor_companyname},#{wor_workname},#{wor_action}," +
            " #{wor_dimission},#{wor_workduty},#{res_id})")
    Integer res_insertWork(Work_experience work_experience);
//    ɾ����������
    @Delete("delete from work_experience where wor_id=#{wor_id}")
    Integer res_deleteWork(Integer wor_id);
//    �޸Ĺ�������--��ʾ����
    @Select("select * from work_experience where wor_id=#{wor_id}")
    List<Map<String,Object>> res_queryByIdWork(Integer wor_id);
//    �޸Ĺ�������
    @Update("update work_experience set wor_companyname=#{wor_companyname}," +
            "wor_workname=#{wor_workname},wor_action=#{wor_action}," +
            "wor_dimission=#{wor_dimission},wor_workduty=#{wor_workduty}" +
            " where wor_id=#{wor_id}")
    Integer res_updateWork(Work_experience work_experience);
//    �����Ŀ����
    @Insert("insert into project_experience(pro_name,pro_role,pro_action,pro_finish,pro_describe,wor_id)" +
            " values(#{pro_name},#{pro_role},#{pro_action},#{pro_finish},#{pro_describe},#{wor_id})")
    Integer res_insertProject(Project_experience project_experience);
//    �޸���Ŀ����--��ѯ����
    @Select("select * from project_experience where pro_id=#{pro_id}")
    List<Map<String,Object>> res_queryByIdProject(Integer pro_id);
    Integer test();


    @Update("update resume set res_education=#{res_education} where res_id=#{res_id}")
    Integer updateRes(Resume resume);
}
