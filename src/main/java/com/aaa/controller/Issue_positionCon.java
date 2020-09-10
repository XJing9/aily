package com.aaa.controller;

import com.aaa.dao.Issue_positionDao;
import com.aaa.entity.Issue_position;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("IssCon")
public class Issue_positionCon {
    @Resource
    Issue_positionDao issue_positionDao;
    @RequestMapping("IssQuery")
    public String IssQuery(Integer iss_id, Model model){
        model.addAttribute("issList",issue_positionDao.issQuery(iss_id));
        return "main/posDetail";
    }
    /*
    * 企业中心--发布职位
    * */
//    显示职位信息
    @RequestMapping("iss_queryPos")
    public String iss_queryPos(Integer ent_id,Model model){
        model.addAttribute("issList",issue_positionDao.iss_queryPos(ent_id));
        return "main/issue_position";
    }
//    根据职位id显示当前职位的详细信息
    @RequestMapping("iss_queryDetailPos")
    @ResponseBody
    public String iss_queryDetailPos(Integer iss_id, HttpSession session){
        //session.setAttribute("posDelList",null);
        session.setAttribute("posDelList",issue_positionDao.iss_queryDetailPos(iss_id));
        return "0";
    }
//    添加职位信息
    @RequestMapping("iss_insertPos")
    @ResponseBody
    public Integer iss_queryPos(Issue_position issue_position){
        /*获取系统当前时间*/
        Date d=new Date();
        long time=new Date().getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateTime=format.format(time);
//        设置发布职位时间
        issue_position.setIss_time(dateTime);

        Integer count=issue_positionDao.iss_insertPos(issue_position);
        return count<1?0:1;
    }
//    上架，下架
    @RequestMapping("iss_updateState")
    @ResponseBody
    public Integer iss_updateState(Integer iss_id,Integer iss_state){
        System.out.println(iss_id);
        System.out.println(iss_state);
        if(iss_state!=0){
            iss_state=0;
        }else{
            iss_state=1;
        }
        Integer count=issue_positionDao.iss_updateState(iss_state,iss_id);
        return count<1?0:1;
    }
//    删除职位信息
    /*@RequestMapping("iss_deletePos")
    @ResponseBody
    public Integer iss_deletePos(String iss_id){
        int count=0;
        if(iss_id.length()<1){
            String[] array=iss_id.split(",");
            for (String i:array){
                count=issue_positionDao.iss_deletePos(i);
                count++;
            }
        }else{
            count=issue_positionDao.iss_deletePos(iss_id);
        }
        return count<1?0:1;
    }*/

}
