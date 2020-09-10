package com.aaa.controller;

import com.aaa.dao.InvitedDao;
import com.aaa.entity.Invited;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("InvitedCon")
public class InvitedCon {
    @Resource
    InvitedDao invitedDao;

    /*添加面试邀请*/
    @RequestMapping("insertInv")
    @ResponseBody
    public Integer insertInv(Invited invited){
        /*获取系统当前时间*/
        Date d=new Date();
        long time=new Date().getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateTime=format.format(time);
        invited.setInv_time(dateTime);

        return invitedDao.insertInv(invited);
    }
    /*查重*/
    @RequestMapping("checkRep")
    @ResponseBody
    public Integer checkRep(Invited invited){
        return invitedDao.checkRep(invited);
    }
    /*应聘者个人中心--求职管理(面试邀请)*/
    @RequestMapping("queryInv")
    public String queryInv(Model model,Integer cus_id){
        Integer res_id=invitedDao.queryRid(cus_id);
        List<Map<String,Object>> invList=invitedDao.queryInv(res_id);
        if(invList.size()>=1){
            model.addAttribute("invList",invList);
        }
        return "main/resInter";
    }
//    显示面试详情数据
    @RequestMapping("inv_queryInter")
    @ResponseBody
    public Integer inv_queryInter(Integer inv_id, HttpSession session){
        session.setAttribute("interList",invitedDao.inv_queryInter(inv_id));
        System.out.println(invitedDao.inv_queryInter(inv_id));
        return 0;
    }
//    面试邀请处理（接受，忽略）
    @RequestMapping("inv_updateState")
    @ResponseBody
    public Integer inv_updateState(Integer inv_state,Integer inv_id){
        Integer count=invitedDao.inv_updateState(inv_state,inv_id);
        return count<1?0:1;
    }
    /*应聘者个人中心--求职管理（已申请职位）*/
    @RequestMapping("queryDel")
    public String queryDel(Model model,Integer cus_id){
        Integer res_id=invitedDao.queryRid(cus_id);
        List<Map<String,Object>> delList=invitedDao.queryDel(res_id);
        if(delList.size()>=1){
            model.addAttribute("delList",delList);
        }
        return "main/jobApp";
    }
}
