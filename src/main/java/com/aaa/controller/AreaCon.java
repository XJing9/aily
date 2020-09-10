package com.aaa.controller;

import com.aaa.dao.AreaDao;
import com.aaa.dao.EntrepreneurDao;
import com.aaa.dao.Issue_positionDao;
import com.aaa.dao.WelfareDao;
import com.aaa.entity.Area;
import com.aaa.entity.Issue_position;
import com.aaa.entity.Welfare;
import com.aaa.util.PageHelpers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Configuration
@RequestMapping("areaCon")
public class AreaCon {
    @Resource
    AreaDao areaDao;
    @Resource
    WelfareDao welfareDao;
    @Resource
    private EntrepreneurDao entrepreneurDao;
    @Resource
    Issue_positionDao issue_positionDao;

    private PageHelpers pageHelpers;

    /*查询地区信息*/
    @RequestMapping("queryArea")
    @ResponseBody
    public List<Map<String,Object>> queryArea(){
        List<Map<String, Object>> areList=areaDao.queryOne();
        return areList;
    }
    /*获取地标信息*/
    @RequestMapping("landmarkQuery")
    @ResponseBody
    public List<Map<String,Object>> landmarkQuery(Integer are_id){
        return areaDao.queryTwo(are_id);
    }
   /* @RequestMapping("test")
    @ResponseBody
    public List<Map<String,Object>> test(Issue_position issue_position){
        return issue_positionDao.issQuery(issue_position);
    }*/

    /*
    * 找工作--页面数据
    * */
    @RequestMapping("queryAre")
    public String select(Integer are_id, Model model, Welfare welfare,PageHelpers ph,Issue_position issue_position){

        /*List<Map<String, Object>> areList=areaDao.queryOne();
        for (Map<String,Object> a:areList){
            List<Map<String,Object>> twoList= areaDao.queryTwo(a.get("are_id"));
            a.put("twoList",twoList);
        }
        model.addAttribute("areList",areList);*/
        model.addAttribute("welList",welfareDao.wel_query(welfare));

        /*
        * 职位信息
        * */
        PageHelper.startPage(ph.getPageNum(),ph.getPageSize());
        List<Map<String,Object>> posList =entrepreneurDao.positionQuery(issue_position);
        for (Map<String,Object> p:posList){
            List<Map<String,Object>> issWelList=welfareDao.issWelQuery((Integer) p.get("iss_id"));
            p.put("issWelList",issWelList);
        }
        ph.setRows(posList);
        PageInfo<Map<String,Object>> pageInfo = new PageInfo<Map<String,Object>>(posList);
        int pages = pageInfo.getPages();
        ph.setLastPage(pages);
        ph.setTotalCount(entrepreneurDao.totalCount());
        if(issue_position!=null){
            model.addAttribute("issue_position",issue_position);
        }
        model.addAttribute("posList",ph);
        return "main/recruitmentList";
    }
    @RequestMapping("add")
    public Integer add(Area area){
        return areaDao.insertSelective(area);
    }

    @RequestMapping("delete")
    public Integer delete(Integer are_id){
        return areaDao.deleteByPrimaryKey(are_id);
    }
    @RequestMapping("update")
    public Integer update(Area area){
        return areaDao.updateByPrimaryKeySelective(area);
    }
}
