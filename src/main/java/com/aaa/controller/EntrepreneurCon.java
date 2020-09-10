package com.aaa.controller;

import com.aaa.dao.AreaDao;
import com.aaa.dao.EntrepreneurDao;
import com.aaa.dao.IndustryDao;
import com.aaa.dao.Issue_positionDao;
import com.aaa.entity.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Controller
@RequestMapping("Entrepreneur")
public class EntrepreneurCon {
    @Resource
    private EntrepreneurDao entrepreneurDao;
    @Resource
    private AreaDao areaDao;
    @Resource
    private IndustryDao industryDao;
    @Resource
    private Issue_positionDao issue_positionDao;

    /*
     *企业个人中心
     * */

    //    企业资料
//    显示
    @RequestMapping("entBasicData")
    public String entData(Model model,Integer ent_id,Integer cus_id,Integer cus_type){
        List<Map<String,Object>> entList=entrepreneurDao.ent_basicData(ent_id);
        List<Map<String,Object>> welList=entrepreneurDao.ent_queryById(ent_id);
        model.addAttribute("welList",welList);
        model.addAttribute("entList",entList);
        model.addAttribute("ent_id",ent_id);
        model.addAttribute("cus_id",cus_id);
        model.addAttribute("cus_type",cus_type);
        return "main/entBasicData";
    }

    /*添加企业信息*/
    @RequestMapping("insertEnt")
    @ResponseBody
    public String insertEnt(Entreprenenur entreprenenur, Customer customer,String strWel){
        Integer count=entrepreneurDao.insertEnt(entreprenenur);
        /*查询当前插入的企业id*/
        Integer ent_id=entrepreneurDao.findEid();
        //        添加企业福利信息
        if(strWel.length()<1){
            entrepreneurDao.ent_insertWel(ent_id,strWel);
        }else{
            String[] array=strWel.split(",");
            for (String i:array){
                entrepreneurDao.ent_insertWel(ent_id,i);
            }
        }
        /*修改当前用户关联企业id*/
        if(count<1){
            return "0";
        }else{
            customer.setEnt_id(ent_id);
            Integer count2=entrepreneurDao.updateEntId(customer);
            return count2<1?"0":"1";
        }

    }
//    修改
    @RequestMapping("ent_update")
    @ResponseBody
    public Integer ent_update(Entreprenenur entreprenenur,String strWel){
        Integer count=entrepreneurDao.ent_update(entreprenenur);
//        先删除当前企业关联的企业福利
        Integer delCount=entrepreneurDao.ent_deleteWel(entreprenenur.getEnt_id());
        //        修改企业福利信息
        if(strWel.length()<1){
            entrepreneurDao.ent_insertWel(entreprenenur.getEnt_id(),strWel);
        }else{
            String[] array=strWel.split(",");
            for (String i:array){
                entrepreneurDao.ent_insertWel(entreprenenur.getEnt_id(),i);
            }
        }
        return count<1?0:1;
    }
//    根据用户id查询企业id
    /*@RequestMapping("ent_cidFindeid")
    @ResponseBody
    public Integer ent_cidFindeid(Integer cus_id){
        return entrepreneurDao.ent_cidFindeid(cus_id);
    }*/
//    职位管理--面试邀请
    @RequestMapping("ent_invInterview")
    public String ent_invInterview(Integer ent_id,Model model){
        List<Map<String,Object>> entList=entrepreneurDao.ent_invInterview(ent_id);
        model.addAttribute("entList",entList);
        return "main/posMg";
    }
//    职位管理--申请面试
    @RequestMapping("ent_applyInter")
    public String ent_applyInter(Model model,Integer ent_id){
        model.addAttribute("entList",entrepreneurDao.ent_applyInter(ent_id));
        return "main/applyInter";
    }
//    职位管理--面试地址管理
//    查询
    @RequestMapping("ent_queryAdd")
    public String ent_queryAdd(Model model,Integer ent_id){
        model.addAttribute("addList",entrepreneurDao.ent_queryAdd(ent_id));
        return "main/interAddress";
    }
//    删除
    @RequestMapping("ent_deleteAdd")
    @ResponseBody
    public Integer ent_deleteAdd(String int_id){
        int count=0;
        if(int_id.length()<1){
            count=entrepreneurDao.ent_deleteAdd(int_id);
        }else{
            String[] array=int_id.split(",");
            for (String i:array){
                count=entrepreneurDao.ent_deleteAdd(i);
                count++;
            }
        }
        return count<1?0:1;
    }
//    添加
    @RequestMapping("ent_insertAdd")
    @ResponseBody
    public Integer ent_insertAdd(Interview interview){
        Integer count=entrepreneurDao.ent_insertAdd(interview);
        if(count<1){
            return 0;
        }else{
            return 1;
        }
    }

   /* @RequestMapping("query")
    @ResponseBody
    public String positionQuery(String ent_name, Model model,Integer iss_id){
        model.addAttribute("positionQuery",entrepreneurDao.positionQuery());
        return "main/";
    }*/

    @RequestMapping("queryare")
    @ResponseBody
    public List<Area>queryare(){
        return areaDao.selectAll();
    }

    @RequestMapping("queryind")
    @ResponseBody
    public List<Industry>queryind(){
        return industryDao.selectAll();
    }

    @RequestMapping("add")
    @ResponseBody
    public String addent(@RequestBody Entreprenenur entreprenenur){
        Integer i=entrepreneurDao.insertSelective(entreprenenur);
        return "ok";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String deleteent(Integer ent_id){
        Integer i=entrepreneurDao.deleteent(ent_id);
        return "ok";
    }

    @RequestMapping("update")
    @ResponseBody
    public String updateent(@RequestBody Entreprenenur entreprenenur){
        System.out.println(entreprenenur);
        Integer i=entrepreneurDao.updent(entreprenenur);
        System.out.println(i);
        return "ok";
    }

   /* @RequestMapping("queryissent")
    @ResponseBody
    public List<Entreprenenur>queryissent(Integer ent_id){
        System.out.println(ent_id);
        List<Entreprenenur> listissent=entrepreneurDao.listissent(ent_id);
        System.out.println(listissent);
        return listissent;
    }*/

    @RequestMapping("queryissent2")
    @ResponseBody
    public List<Issue_position>queryissent2(Integer ent_id){
        System.out.println(ent_id);
        List<Issue_position> listissent=entrepreneurDao.listissent2(ent_id);
        System.out.println(listissent);
        return listissent;
    }

    /*@RequestMapping("listquery")
    @ResponseBody
    public List<Entreprenenur>lisstquery(){
        return entrepreneurDao.listQuery();
    }*/

    @RequestMapping("updqyzt")
    @ResponseBody
    public String updateqyzt(@RequestBody Entreprenenur entreprenenur){
        Integer i=entrepreneurDao.updzyzt(entreprenenur);
        System.out.println(i);
        return "ok";
    }

    @RequestMapping("updzt")
    @ResponseBody
    public String updatezt(@RequestBody Entreprenenur entreprenenur){
        Entreprenenur e1=new Entreprenenur();
        e1.setEnt_authentication(0);
        Integer i=entrepreneurDao.updzt(e1);
        return "ok";
    }
}
