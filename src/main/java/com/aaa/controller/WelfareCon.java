package com.aaa.controller;

import com.aaa.dao.WelfareDao;
import com.aaa.entity.Welfare;
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
@RequestMapping("WelCon")
public class WelfareCon {
    @Resource
    WelfareDao welfareDao;

//    查询企业福利数据信息
    @RequestMapping("wel_queryAll")
    @ResponseBody
    public List<Welfare> wel_queryAll(){
        return welfareDao.selectAll();
    }

    @RequestMapping("wel_query")
    public String wel_query(Welfare welfare, Model model){
        model.addAttribute("welList",welfareDao.wel_query(welfare));
        return "main/recruitmentList.html";
    }

    @RequestMapping("wel_add")
    public Integer wel_add(Welfare welfare) {
        return welfareDao.wel_add(welfare);
    }
    @RequestMapping("wel_update")
    public Integer wel_update(Welfare welfare){
        return welfareDao.wel_update(welfare);
    }

    @RequestMapping("wel_delete")
    public Integer wel_delete(Welfare welfare){
        return welfareDao.wel_delete(welfare);
    }
}
