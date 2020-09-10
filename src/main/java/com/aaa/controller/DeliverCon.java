package com.aaa.controller;

import com.aaa.dao.DeliverDao;
import com.aaa.entity.Deliver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("DeliverCon")
public class DeliverCon {
    @Resource
    DeliverDao deliverDao;

    /*投递简历*/
    @RequestMapping("insertDel")
    @ResponseBody
    public Integer insertDel(Deliver deliver,Integer cus_id){
        /*获取系统当前时间*/
        Date d=new Date();
        long time=new Date().getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateTime=format.format(time);
        deliver.setDel_time(dateTime);
        /*获取用户简历id*/
        Integer res_id=deliverDao.queryRid(cus_id);
        deliver.setRes_id(res_id);
        return deliverDao.insertDel(deliver);
    }
    /*投递简历--查重*/
    @RequestMapping("queryRep")
    @ResponseBody
    public Integer queryRep(Integer cus_id,Integer iss_id){
        /*获取用户简历id*/
        Integer res_id=deliverDao.queryRid(cus_id);
        return deliverDao.queryRep(res_id,iss_id);
    }

    /*
    * 企业用户--面试申请（接受，忽略）
    * */
    @RequestMapping("ent_udpateDelState")
    @ResponseBody
    public Integer ent_udpateDelState(Integer del_state,Integer del_id){
        Integer count=deliverDao.ent_udpateDelState(del_state,del_id);
        return count<1?0:1;
    }
}
