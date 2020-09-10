package com.aaa.controller;
import com.aaa.dao.AreaDao;
import com.aaa.dao.InterviewDao;
import com.aaa.dao.ResumeDao;
import com.aaa.dao.SpecialityDao;
import com.aaa.entity.Resume;
import com.aaa.entity.Speciality;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("resumeCon")
public class ResumeCon {

    @Resource
    ResumeDao resumeDao;
    @Resource
    AreaDao areaDao;
    @Resource
    SpecialityDao specialityDao;
    @Resource
    InterviewDao interviewDao;

    /*
    * 招人才--页面数据
    * */
    @RequestMapping("QueryAll")
    public String QueryAll(Model model, Integer are_id, PageHelpers ph){
        /*地区数据信息*/
       /* List<Map<String,Object>> areList=areaDao.queryOne(are_id);
        List<Map<String,Object>> twoList=areaDao.queryTwo(areList.get(0).get("are_id"));*/
        /*特长标签信息*/
        /*List<Speciality> spesList=specialityDao.selectAll();
        areList.get(0).put("twoList",twoList);*/

        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());

        List<Map<String,Object>> resList=resumeDao.QueryAll();
        for (Map<String,Object> r:resList){
            List<Map<String,Object>> speList=resumeDao.QuerySpe((Integer) r.get("res_id"));
            if(speList.size()<1){
                speList=null;
            }
            r.put("speList",speList);
        }
        ph.setRows(resList);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(resList);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        System.out.println(ph.getRows());
        ph.setTotalCount(resumeDao.totalCount());

       /* model.addAttribute("areList",areList);
        model.addAttribute("spesList",spesList);*/
        model.addAttribute("resList",ph);
        return "main/resumeList";
    }

    /*
    * 面试邀请
    * */

//    判断企业是否添加过地址
    @RequestMapping("inv_address")
    @ResponseBody
    public String inv_address(Integer cus_id){
//        面试邀请，存储地址信息
        List<Map<String,Object>> cusList=resumeDao.inv_queryCus(cus_id);
        List<Map<String,Object>> addList=interviewDao.queryIn_a((Integer) cusList.get(0).get("ent_id"));
        if(addList.size()<1){
            return "defeat";
        }else{
            return "success";
        }
    }
//    获取企业面试地址信息
    @RequestMapping("inv_addressData")
    @ResponseBody
    public List<Map<String,Object>> inv_addressData(Integer cus_id){
        List<Map<String,Object>> cusList=resumeDao.inv_queryCus(cus_id);
        List<Map<String,Object>> addList=interviewDao.queryIn_a((Integer) cusList.get(0).get("ent_id"));
        return addList;
    }
//    根据企业面试地址id查询地址信息
    @RequestMapping("inv_queryIdAddData")
    @ResponseBody
    public List<Map<String,Object>> inv_queryIdAddData(Integer int_id){
        System.out.println("hhh");
        return resumeDao.inv_queryIdAddData(int_id);
    }
/*
//    获取默认地址
    @RequestMapping("inv_address_m")
    public String inv_address_m(Integer cus_id){
        Integer ent_id=resumeDao.inv_queryEid(cus_id);
        List<Map<String,Object>> addList=interviewDao.queryIn_m(ent_id);
        if(addList.size()<1){
            return "请添加默认地址";
        }
        return ;
    }
*/

    /*修改求职意向*/
    @RequestMapping("updateRes")
    @ResponseBody
    public Integer updateRes(Resume resume){
        return resumeDao.updateRes(resume);
    }

    /*@RequestMapping("update")
    public String update(Resume resume){
        resumeDao.update(resume);
        return "OK";
    }

    @RequestMapping("delete")
    public  String delete(Resume resume){
        resumeDao.delete(resume);
        return "OK";
    }*/
}
