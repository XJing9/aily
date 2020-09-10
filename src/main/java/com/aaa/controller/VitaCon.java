package com.aaa.controller;

import com.aaa.dao.*;
import com.aaa.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("vitaCon")
public class VitaCon {
    @Resource
    ResumeDao resumeDao;
    @Resource
    Edu_experienceDao edu_experienceDao;
    @Resource
    Work_experienceDao work_experienceDao;
    @Resource
    Pro_experienceDao pro_experienceDao;
    @Resource
    CertificateDao certificateDao;
    @Resource
    IndustrysDao industrysDao;
    @Resource
    LanguageDao languageDao;
    @Resource
    EntrepreneurDao entrepreneurDao;
    @Resource
    Issue_positionDao issue_positionDao;
    @Resource
    InterviewDao interviewDao;

    @RequestMapping("vitaQuery")
    public String vitaQuery(Model model, Integer cus_id, HttpSession session){
        List<Map<String,Object>> vitaQuery=resumeDao.vitaQuery(cus_id);
        for (Map<String,Object> m:vitaQuery){
            /*个性标签*/
            List<Map<String,Object>> speList=resumeDao.QuerySpe((Integer) m.get("res_id"));
            /*教育经历*/
            List<Map<String,Object>> eduList=edu_experienceDao.edu_query((Integer) m.get("res_id"));
            /*工作经历*/
            List<Map<String,Object>> worList=work_experienceDao.wor_query((Integer) m.get("res_id"));
            for(Map<String,Object> w:worList){
                /*项目经历*/
                List<Map<String,Object>> proList=pro_experienceDao.proQuery((Integer) w.get("wor_id"));
                w.put("proList",proList);
            }
            /*获得证书*/
            List<Map<String,Object>> cerList=certificateDao.cer_query((Integer) m.get("res_id"));
            /*语言能力*/
            List<Map<String,Object>> lanList=languageDao.lan_query((Integer) m.get("res_id"));

            m.put("lanList",lanList);
            m.put("cerList",cerList);
            m.put("eduList",eduList);
            m.put("worList",worList);
            m.put("speList",speList);
        }
        model.addAttribute("vitaQuery",vitaQuery);
        return "main/vita";
    }
    /*
    * 面试邀请
    * */

//    判断企业是否发布招聘信息
    @RequestMapping("inv_checkQueryPos")
    @ResponseBody
    public String inv_checkQueryPos(Integer cus_id){
        Integer ent_id=entrepreneurDao.queryEid(cus_id);
        /*显示企业发布的招聘信息*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);
        if(posList.size()<1){
            return "defeat";
        }else{
            return "success";
        }
    }
//    显示企业发布的招聘信息
    @RequestMapping("queryPos")
    @ResponseBody
    public List<Map<String,Object>> queryPos(Integer cus_id){
        System.out.println(cus_id);
        /*获取企业id*/
        Integer ent_id=entrepreneurDao.queryEid(cus_id);
        System.out.println(ent_id);
        /*显示企业发布的招聘信息*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);
        return posList;
    }
//    根据职位id查找职位信息
    @RequestMapping("queryPosId")
    @ResponseBody
    public List<Map<String,Object>> queryPosId(Integer iss_id){
        /*显示企业发布的招聘信息*/
        /*List<Map<String,Object>> posIdList=issue_positionDao.posIdQuery(iss_id);
        session.setAttribute("posIdList",posIdList);
        System.out.println("posIdList已经存进去了");*/
        return issue_positionDao.posIdQuery(iss_id);
    }

    /*查找选中的地址信息*/
    @RequestMapping("queryAddId")
    @ResponseBody
    public List<Map<String,Object>> queryAddId(Integer int_id){
        return interviewDao.queryAdd(int_id);
    }
}
