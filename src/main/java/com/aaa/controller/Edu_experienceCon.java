package com.aaa.controller;

import com.aaa.dao.Edu_experienceDao;
import com.aaa.entity.Edu_experience;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("EduCon")
public class Edu_experienceCon {
    @Resource
    Edu_experienceDao edu_experienceDao;

    @RequestMapping("edu_query")
    public List<Map<String,Object>> edu_query(Edu_experience edu_experience){
        return edu_experienceDao.edu_query(edu_experience.getRes_id());
    }

    @RequestMapping("edu_add")
    public Integer edu_add(Edu_experience edu_experience){
        return edu_experienceDao.edu_add(edu_experience);
    }

    @RequestMapping("edu_update")
    public Integer edu_update(Edu_experience edu_experience){
        return edu_experienceDao.edu_update(edu_experience);
    }

    @RequestMapping("edu_delete")
    public Integer edu_delete(Edu_experience edu_experience){
        return edu_experienceDao.edu_delete(edu_experience);
    }
}
