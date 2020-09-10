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
    /*��ʾ��ҵ��ϸ��Ϣ*/
    @RequestMapping("companyDetailQuery")
    public String companyDetailQuery(Integer ent_id, Model model){
        /*��ʾ��ҵ��ϸ��Ϣ*/
        List<Map<String,Object>> entList=entrepreneurDao.listQuery(ent_id);
        /*��ʾ��ҵ������Ϣ*/
        List<Map<String,Object>> welList=entrepreneurDao.welQuery(ent_id);
        /*��ʾ��ҵ������ְλ��Ϣ*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);

        /*��ʾ��ҵ������ְλ��Ϣ��ǰ������*/
        List<Map<String,Object>> posLimitList=entrepreneurDao.posQueryLimit(ent_id);
        model.addAttribute("entList",entList);
        model.addAttribute("welList",welList);

        model.addAttribute("posLimitList",posLimitList);
        /*����ְλ����*/
        model.addAttribute("posCount",posList.size());

        System.out.println(entList.get(0).get("ind_name"));
        System.out.println(entList.get(0).get("are_name"));
        return "main/companyDetail";
    }

    /*��ʾ��ҵ��Ƹ��Ϣ*/
    @RequestMapping("comPosQuery")
    public String comPosQuery(Integer ent_id, Model model){
        /*��ʾ��ҵ��ϸ��Ϣ*/
        List<Map<String,Object>> entList=entrepreneurDao.listQuery(ent_id);
        /*��ʾ��ҵ������ְλ��Ϣ*/
        List<Map<String,Object>> posList=entrepreneurDao.posQuery(ent_id);
        model.addAttribute("entList",entList);

        model.addAttribute("posList",posList);
        /*����ְλ����*/
        model.addAttribute("posCount",posList.size());
        return "main/comPosList";
    }
}
