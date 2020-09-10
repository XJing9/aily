package com.aaa.controller;

import com.aaa.dao.IndustryDao;
import com.aaa.dao.PositionDao;
import com.aaa.entity.Industry;
import com.aaa.entity.Position;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
@RequestMapping("IndustryCon")
public class IndustryCon {
    @Resource
    IndustryDao industryDao;
    @Resource
    PositionDao positionDao;

    /*显示行业信息*/
    @RequestMapping("indQueryAll")
    @ResponseBody
    public List<Industry> indQueryAll(){
        return industryDao.selectAll();
    }

    @RequestMapping("Ind_query")
    public String Ind_query(Model model){
        List<Industry> indList=industryDao.selectAll();
        for (Industry ind:indList){
            List<Position> posList=positionDao.position_query(ind.getInd_id());
            ind.setPosition(posList);
        }
        model.addAttribute("IndList",indList);
        return "main/inviteMessage";
    }

    /*
    * 根据行业id,查询职位信息
    * */
    @RequestMapping("posDataAll")
    @ResponseBody
    public List<Position> posDataAll(Model model,Integer ind_id){
        return positionDao.position_query(ind_id);
    }
    /*根据行业类型id查询行业*/
    @RequestMapping("queryInd")
    @ResponseBody
    public List<Industry> queryInd(Integer indu_id, HttpSession session){
        //session.setAttribute("sessionIndList",industryDao.Ind_query(indu_id));
        return industryDao.Ind_query(indu_id);
    }
    @RequestMapping("Ind_add")
    public Integer Ind_add(Industry industry){
        return industryDao.Ind_add(industry);
    }

    @RequestMapping("Ind_update")
    public Integer Ind_update(Industry industry){
        return industryDao.Ind_update(industry);
    }

    @RequestMapping("Ind_delete")
    public Integer Ind_delete(Industry industry){
        return industryDao.Ind_delete(industry);
    }
}
