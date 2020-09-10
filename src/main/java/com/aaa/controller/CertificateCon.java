package com.aaa.controller;

import com.aaa.dao.CertificateDao;
import com.aaa.entity.Certificate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("CerCon")
public class CertificateCon {
    @Resource
    CertificateDao certificateDao;

    @RequestMapping("cer_query")
    public List<Map<String,Object>> cer_query(Certificate certificate){
        return certificateDao.cer_query(certificate.getRes_id());
    }

    @RequestMapping("cer_add")
    public Integer cer_add(Certificate certificate){
        return certificateDao.cer_add(certificate);
    }

    @RequestMapping("cer_update")
    public Integer cer_update(Certificate certificate){
        return certificateDao.cer_update(certificate);
    }

    @RequestMapping("cer_delete")
    public Integer cer_delete(Certificate certificate){
        return certificateDao.cer_delete(certificate);
    }
}
