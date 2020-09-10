package com.aaa.controller;

import com.aaa.dao.EntrepreneurDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("companyDetailCon")
public class CompanyDetailCon {
    @Resource
    EntrepreneurDao entrepreneurDao;
    /*显示企业详细信息*/
    @RequestMapping("companyDetailQuery")
    public String companyDetailQuery(Integer ent_id, Model model){
        /*显示企业详细信息*/
        List<Map<String,Object>> entList=entrepreneurDao.listQuery(ent_id);
        /*显示企业福利信息*/
        List<Map<String,Object>> welList=entrepreneurDao.welQuery(ent_id);
        /*显示企业发布的职位信息*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);

        /*显示企业发布的职位信息（前四条）*/
        List<Map<String,Object>> posLimitList=entrepreneurDao.posQueryLimit(ent_id);
        model.addAttribute("entList",entList);
        model.addAttribute("welList",welList);

        model.addAttribute("posLimitList",posLimitList);
        /*在招职位数量*/
        model.addAttribute("posCount",posList.size());

        System.out.println(entList.get(0).get("ind_name"));
        System.out.println(entList.get(0).get("are_name"));
        return "main/companyDetail";
    }

    /*显示企业招聘信息*/
    @RequestMapping("comPosQuery")
    public String comPosQuery(Integer ent_id, Model model){
        /*显示企业详细信息*/
        List<Map<String,Object>> entList=entrepreneurDao.listQuery(ent_id);
        /*显示企业发布的职位信息*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);
        model.addAttribute("entList",entList);

        model.addAttribute("posList",posList);
        /*在招职位数量*/
        model.addAttribute("posCount",posList.size());
        return "main/comPosList";
    }
}
