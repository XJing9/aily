package com.aaa.controller;

import com.aaa.dao.LanguageDao;
import com.aaa.entity.Language;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("LanCon")
public class LanguageCon {
    @Resource
    LanguageDao languageDao;

    @RequestMapping("lan_query")
    public List<Map<String,Object>> lan_query(Language language){
        return languageDao.lan_query(language.getRes_id());
}

    @RequestMapping("lan_add")
    public Integer lan_add(Language language){
        return languageDao.lan_add(language);
    }

    @RequestMapping("lan_update")
    public Integer lan_update(Language language){
        return languageDao.lan_update(language);
    }

    @RequestMapping("lan_delete")
    public Integer lan_delete(Language language){
        return languageDao.lan_delete(language);
    }
}
