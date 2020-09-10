package com.aaa.dao;

import com.aaa.entity.Resume;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResumeDao extends tk.mybatis.mapper.common.Mapper<Resume>{
    /*根据用户id查询企业id*/
    @Select("select * from customer where cus_id=#{cus_id}")
    List<Map<String,Object>> inv_queryCus(Integer cus_id);
    /*
    * 面试邀请
    * */
//    根据面试地址id查询地址信息
    @Select("select * from interview where int_id=#{int_id}")
    List<Map<String,Object>> inv_queryIdAddData(Integer int_id);

    @Select("select re.`*`,cu.cus_truename,cu.cus_introduce,cu.cus_sex,cu.cus_workyear,cu.cus_birthday\n" +
            "from resume re\n" +
            "join customer cu\n" +
            "on re.cus_id=cu.cus_id" +
            " where cu.cus_type=1")
    List<Map<String,Object>> QueryAll();

    @Select("select sp.spe_name\n" +
            "from spe_res sr\n" +
            "join speciality sp\n" +
            "on sr.spe_id=sp.spe_id\n" +
            "join resume re\n" +
            "on re.res_id=sr.res_id\n" +
            "where re.res_id=#{res_id}")
    List<Map<String,Object>> QuerySpe(Integer res_id);

    @Select("select count(re.res_id)\n" +
            "from resume re\n" +
            "join customer cu\n" +
            "on re.cus_id=cu.cus_id")
    Integer totalCount();

    @Select("select re.`*`,cu.cus_introduce,cu.cus_phone,cu.cus_email,cu.cus_truename,cu.cus_id,cu.cus_address,cu.cus_sex,cu.cus_workyear,cu.cus_birthday\n" +
            "from resume re\n" +
            "join customer cu\n" +
            "on re.cus_id=cu.cus_id\n" +
            "where cu.cus_id=#{cus_id}")
    List<Map<String,Object>> vitaQuery(Integer cus_id);

    /*修改求职意向*/
    @Update("update resume set" +
            " res_jobstate=#{res_jobstate},res_workcategory=#{res_workcategory}," +
            " res_industry=#{res_industry},res_job=#{res_job},res_workaddress=#{res_workaddress}" +
            " where res_id=#{res_id}")
    Integer updateRes(Resume resume);
    /*
    //根据ID修改状态  用户简历只能查看 无法修改其个人信息
    @Update("update resume set res_state=#{res_state} where res_id=#{res_id}")
    Integer update(Resume resume);

    @Delete("delete from resume where res_id=#{res_id}")
    int delete(Resume resume);*/
}
