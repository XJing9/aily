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

    /*Ͷ�ݼ���*/
    @RequestMapping("insertDel")
    @ResponseBody
    public Integer insertDel(Deliver deliver,Integer cus_id){
        /*��ȡϵͳ��ǰʱ��*/
        Date d=new Date();
        long time=new Date().getTime();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String dateTime=format.format(time);
        deliver.setDel_time(dateTime);
        /*��ȡ�û�����id*/
        Integer res_id=deliverDao.queryRid(cus_id);
        deliver.setRes_id(res_id);
        return deliverDao.insertDel(deliver);
    }
    /*Ͷ�ݼ���--����*/
    @RequestMapping("queryRep")
    @ResponseBody
    public Integer queryRep(Integer cus_id,Integer iss_id){
        /*��ȡ�û�����id*/
        Integer res_id=deliverDao.queryRid(cus_id);
        return deliverDao.queryRep(res_id,iss_id);
    }

    /*
    * ��ҵ�û�--�������루���ܣ����ԣ�
    * */
    @RequestMapping("ent_udpateDelState")
    @ResponseBody
    public Integer ent_udpateDelState(Integer del_state,Integer del_id){
        Integer count=deliverDao.ent_udpateDelState(del_state,del_id);
        return count<1?0:1;
    }
}
