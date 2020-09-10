package com.aaa.controller;

import com.aaa.dao.IndustrysDao;
import com.aaa.entity.Industrys;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("IndustrysCon")
public class IndustrsCon {
    @Resource
    IndustrysDao industrysDao;
    /*
     * 查询行业信息
     * */
    @RequestMapping("queryAllInd")
    @ResponseBody
    public List<Industrys> queryAllInd(){
        return industrysDao.selectAll();
    }
}
