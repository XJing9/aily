package com.aaa.controller;

import com.aaa.dao.Work_experienceDao;
import com.aaa.entity.Work_experience;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("WorCon")
public class Work_experienceCon {
    @Resource
    Work_experienceDao work_experienceDao;

    @RequestMapping("wor_query")
    public List<Map<String,Object>> wor_query(Work_experience work_experience) {
        return work_experienceDao.wor_query(work_experience.getRes_id());
    }

    @RequestMapping("wor_add")
    public Integer wor_add(Work_experience work_experience){
        return work_experienceDao.wor_add(work_experience);
    }

    @RequestMapping("wor_update")
    public Integer  wor_update(Work_experience work_experience){
        return work_experienceDao.wor_update(work_experience);
    }

    @RequestMapping("wor_delete")
    public Integer wor_delete(Work_experience work_experience){
        return work_experienceDao.wor_delete(work_experience);
    }
}
