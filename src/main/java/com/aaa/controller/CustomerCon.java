package com.aaa.controller;

import com.aaa.dao.*;
import com.aaa.entity.*;
import com.aaa.util.Sendsms;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("CustomerCon")
public class CustomerCon {
    @Resource
    CustomerDao customerDao;
    @Resource
    IndustryDao industryDao;
    @Resource
    PositionDao positionDao;
    @Resource
    Edu_experienceDao edu_experienceDao;
    @Resource
    Work_experienceDao work_experienceDao;
    @Resource
    Pro_experienceDao pro_experienceDao;
    @Resource
    CertificateDao certificateDao;
    @Resource
    LanguageDao languageDao;
    @Resource
    SpecialityDao specialityDao;
    @Resource
    ResumeDao resumeDao;
    @Resource
    IndustrysDao industrysDao;
    @Resource
    InterviewDao interviewDao;
    @Resource
    EntrepreneurDao entrepreneurDao;
    @Resource
    PhotoDao photoDao;

    public Sendsms sendsms=new Sendsms();
    public Integer mobile_code;
    public Integer count=0;
    public List<Map<String,Object>> cusList=null;

    /*用户登录*/
    /*账户密码登录*/
    @RequestMapping("customer_login")
    @ResponseBody
    public String customer_login(Customer customer){
        /*判断用户名是否存在*/
        List<Map<String,Object>> queryName=customerDao.queryName(customer.getCus_name());
        if(queryName.size()<1){
            /*用户不存在*/
            return "用户不存在";
        }else{
            /*判断密码是否正确*/
            List<Map<String,Object>> login=customerDao.customer_login(customer);
            if(login.size()>=1){
                String cus_state= (String) login.get(0).get("cus_state");
                if(cus_state.equals("1")){
                    //登录成功
                    return "success";
                }else{
                    return "账户异常，暂时无法登录";
                }
            }else{
                //密码错误
                return "密码错误";
            }
        }
    }
    /*手机号登录*/
    @RequestMapping("loginPhone")
    @ResponseBody
    public String loginPhone(String cus_phone, Integer securityCode){
        if(mobile_code!=null){
            if(mobile_code.equals(securityCode)){
                List<Customer> loginPhone=customerDao.loginPhone(cus_phone);

                if(loginPhone.size()>=1){
                    String cus_state=loginPhone.get(0).getCus_state();
                    if(cus_state.equals("1")){
                        return "success";
                    }else{
                        return "账户异常，暂时无法登录";
                    }
                }else{
                    return "此用户没有注册，请先注册";
                }

            }else{

                return "验证码不正确";
            }
        }else if(mobile_code==null && count!=0){
            return "验证码已失效";
        }else{
            return "请先获取验证码";
        }
    }

    /*账户密码正确，根据账户密码获取用户其他信息,跳转主页面*/
    @RequestMapping("queryCusMg")
    public String queryCusMg(Customer customer,HttpSession session,Model model){
        //cusList=null;
        //if(cusList==null){
            /*获取用户信息*/

        cusList=customerDao.queryAllCus(customer);

        //}
        /*判断当前是否为企业*/
        Integer cus_type= (Integer) cusList.get(0).get("cus_type");
        if(cus_type!=1){
            cusList=customerDao.queryEnt(customer);
        }
//        获取轮播图
        List<Map<String,Object>> queryPhoto=photoDao.queryPhoto();

        model.addAttribute("queryPhoto",queryPhoto);

        /*获取行业类型，职位类型，职位等信息，展示到首页*/
        List<Industrys> induList=industryDao.industrys_queryAll();
        for (Industrys i:induList){
            List<Industry> indList=industryDao.Ind_query(i.getIndu_id());
            //i.("indList",indList);
            i.setIndustry(indList);
            for (Industry ind:indList){
                List<Position> posList=positionDao.position_query(ind.getInd_id());
                //ind.put("posList",posList);
                ind.setPosition(posList);
            }
        }
        model.addAttribute("induList",induList);
        return "main/main";
    }
    /*忘记密码--修改密码*/
    @RequestMapping("updatePwd")
    @ResponseBody
    public String updatePwd(Customer customer){
        Integer count=customerDao.updatePwd(customer);
        if(count>=1){
            return "success";
        }else{
            return "defeat";
        }
    }

    /*主页面的头信息*/
    @RequestMapping("topData")
    public String topData(HttpSession session){
        session.setAttribute("sessionCusList",cusList);
        //将企业信息存入session中
        //获取用户类型
        /*Integer cus_type= (Integer) customers.get(0).get("cus_type");
        List<Map<String,Object>> sessionEntList=null;
        if(cus_type!=1){
            sessionEntList=customerDao.queryEnt((Integer) customers.get(0).get("cus_id"));
            session.setAttribute("sessionEntList",sessionEntList);
        }*/
        /*将企业的地址信息存入session*/
        /*默认地址*/
        /*session.setAttribute("sessionIntList_m",interviewDao.queryIn_m((Integer) sessionEntList.get(0).get("ent_id")));
        // 所以地址信息
        session.setAttribute("sessionIntList_a",interviewDao.queryIn_a((Integer) sessionEntList.get(0).get("ent_id")));
*/
        //model.addAttribute("cuslist",customers);
        return "main/top";
    }

    /*注册*/
//    企业注册
    @RequestMapping("insertEnt")
    @ResponseBody
    public String insertEnt(Customer customer){
        Integer number = 100000 + (int) (Math.random() * (999999 - 100000) + 1);
        customer.setCus_name(number.toString());
        customer.setCus_pwd(number.toString());
        Integer entCount=customerDao.insertEnt(customer);
        if(entCount<1){
            return "defeat";
        }else{
            return "success";
        }
    }

    /*手机号注册*/
    @RequestMapping("regPhone")
    @ResponseBody
    public String regPhone(String cus_phone, Integer securityCode){
        if(mobile_code!=null){
            if(mobile_code.equals(securityCode)){
                List<Customer> loginPhone=customerDao.loginPhone(cus_phone);
                if(loginPhone.size()>=1){
                    return "此手机号已注册";
                }else{
                    return "success";
                }
            }else{
                return "验证码不正确";
            }
        }else if(mobile_code==null && count!=0){
            return "验证码已失效";
        }else{
            return "请先获取验证码";
        }
    }
    /*查询企业账户密码*/
    @RequestMapping("queryEntData")
    @ResponseBody
    public List<Map<String,Object>> queryEntData(HttpSession session, String cus_phone, Model model){
        cusList=customerDao.queryEntData(cus_phone);
        return cusList;
    }
    /*跳转企业个人中心页面*/
    @RequestMapping("show_entData")
    public String show_entData(Model model,Integer cus_id){
        model.addAttribute("cus_id",cus_id);
        return "main/entData";
    }
    /*跳转企业资料页面*/
    @RequestMapping("show_entBasicData")
    public String show_entBasicData(Model model,Integer cus_id){
        model.addAttribute("cus_id",cus_id);
        return "main/entBasicData";
    }

    /*
    * 应聘者注册
    * */
//    添加应聘者信息
    @RequestMapping("reg_insertCus")
    @ResponseBody
    public String reg_insertCus(Customer customer){
        Integer number = 100000 + (int) (Math.random() * (999999 - 100000) + 1);
        customer.setCus_name(number.toString());
        customer.setCus_pwd(number.toString());
        Integer count=customerDao.reg_insertCus(customer);
        if(count<1){
            return "success";
        }else{
            return "defeat";
        }
    }
//    查询新添加的账户密码信息
    @RequestMapping("reg_showCusData")
    @ResponseBody
    public List<Map<String,Object>> reg_showCusData(String cus_phone){
        cusList=customerDao.reg_showCusData(cus_phone);
        return cusList;
    }
//    跳转简历页面
    @RequestMapping("reg_showRes")
    public String reg_showRes(Model model,Integer cus_id,String cus_phone){

        model.addAttribute("cus_id",cus_id);
        model.addAttribute("cus_phone",cus_phone);
        return "main/setResume";
    }

//    修改应聘者信息，添加简历信息
    @RequestMapping("reg_updateCus")
    @ResponseBody
    public Integer reg_updateCus(Customer customer,Resume resume){
        Integer cus_count=customerDao.reg_updateCus(customer);
        if(cus_count<1){
            return 0;
        }else{
            /*获取系统当前时间*/
            Date d=new Date();
            long time=new Date().getTime();
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String dateTime=format.format(time);
            resume.setRes_time(dateTime);
            resume.setCus_id(customer.getCus_id());
            resume.setRes_state(1);
            Integer res_count=customerDao.reg_insertRes(resume);
            return res_count>=1?1:0;
        }
    }

    /*用户个人中心*/
    @RequestMapping("showResinter")
    public String showResinter(Integer cus_type){
        if(cus_type!=1){
            /*企业个人中心*/
            return "main/entData";
        }else{
            /*用户个人中心*/
            return "main/basicInfo";
        }
    }

    /*登录成功进入主页面*/
    /*@RequestMapping("show_main")
    public String show_main(Model model,Integer cus_id,HttpSession session){
        customers=customerDao.customerByCus_id(cus_id);
        model.addAttribute("cuslist",customers);
        List<Industrys> induList=industryDao.industrys_queryAll();
        for (Industrys i:induList){
            List<Industry> indList=industryDao.Ind_query(i.getIndu_id());
            //i.("indList",indList);
            i.setIndustry(indList);
            for (Industry ind:indList){
                List<Position> posList=positionDao.position_query(ind.getInd_id());
                //ind.put("posList",posList);
                ind.setPosition(posList);
            }
        }
        *//*将行业类型存入session中*//*
      *//*  session.setAttribute("sessioninduList",induList);
        *//**//*初始化将行业存入session中*//**//*
        session.setAttribute("sessionIndList",industryDao.Ind_query(1));*//*
        model.addAttribute("induList",induList);
        return "main/main";
    }*/

    /*用户个人中心--我的简历*/
    @RequestMapping("personalQuery")
    public String query(Integer cus_id,Model model){
        List<Map<String,Object>> perList=customerDao.cusQuery(cus_id);
       // System.out.println(perList.get(0).get("res_id"));
        List<Map<String,Object>> eduList=edu_experienceDao.edu_query((Integer) perList.get(0).get("res_id"));
        List<Map<String,Object>> worList=work_experienceDao.wor_query((Integer) perList.get(0).get("res_id"));

        for (Map<String,Object> w:worList){
            List<Map<String,Object>> proList=pro_experienceDao.proQuery((Integer) w.get("wor_id"));
            w.put("proList",proList);
        }
        List<Map<String,Object>> cerList=certificateDao.cer_query((Integer) perList.get(0).get("res_id"));
        System.out.println(perList.get(0).get("res_id"));
        List<Map<String,Object>> lanList=languageDao.lan_query((Integer) perList.get(0).get("res_id"));
        List<Map<String,Object>> speList=specialityDao.speQuery((Integer) perList.get(0).get("res_id"));

        model.addAttribute("speList",speList);
        model.addAttribute("lanList",lanList);

        model.addAttribute("cerList",cerList);
        model.addAttribute("worList",worList);
        model.addAttribute("eduList",eduList);
        model.addAttribute("perList",perList);
        return "main/personal";
    }

    @RequestMapping("clearMobileCode")
    @ResponseBody
    public Integer clearMobileCode(){
        mobile_code=null;
        return mobile_code;
    }

    @RequestMapping("sendAuthCode")
    @ResponseBody
    public Integer sendAuthCode(String cus_phone){
       // System.out.println(cus_phone);
        mobile_code=sendsms.PhoneCode(cus_phone);
        count++;
       // System.out.println(mobile_code);
        return mobile_code;
    }
    /*
    * 我的简历
    * */
//    修改基本信息
    @RequestMapping("updateCus")
    @ResponseBody
    public String updateCus(Customer customer, Resume resume) {
        Integer countCus = customerDao.updateCus(customer);
        Integer countRes = customerDao.updateRes(resume);
        if (countCus >= 1 || countRes >= 1) {
            return "1";
        } else {
            return "0";
        }
    }
//    修改求职意向
    @RequestMapping("res_updateRes")
    @ResponseBody
    public Integer res_updateRes(Resume resume){
        Integer count=customerDao.res_updateRes(resume);
        return count<1?0:1;
    }
//    修改自我描述
    @RequestMapping("res_updateIntro")
    @ResponseBody
    public Integer res_updateIntro(String cus_introduce,Integer cus_id){
        Integer count=customerDao.res_updateIntro(cus_introduce,cus_id);
        return count<1?0:1;
    }
//    添加教育经历
    @RequestMapping("res_insertEdu")
    @ResponseBody
    public Integer res_insertEdu(Edu_experience edu_experience){
        Integer count=customerDao.res_insertEdu(edu_experience);
        return count<1?0:1;
    }
//    删除教育经历
    @RequestMapping("res_deleteEdu")
    @ResponseBody
    public Integer res_deleteEdu(Integer edu_id){
        Integer count=customerDao.res_deleteEdu(edu_id);
        return count<1?0:1;
    }
//    根据编号查询数据
    @RequestMapping("res_queryByIdEdu")
    @ResponseBody
    public List<Map<String,Object>> res_queryByIdEdu(Integer edu_id){
        return customerDao.res_queryByIdEdu(edu_id);
    }
//    修改教育经历
    @RequestMapping("res_updateEdu")
    @ResponseBody
    public Integer res_updateEdu(Edu_experience edu_experience){
        Integer count=customerDao.res_updateEdu(edu_experience);
        return count<1?0:1;
    }
//    添加工作经历
    @RequestMapping("res_insertWork")
    @ResponseBody
    public Integer res_insertWork(Work_experience work_experience){
        System.out.println("");
        Integer count=customerDao.res_insertWork(work_experience);
        return count<1?0:1;
    }
//    删除工作经历
    @RequestMapping("res_deleteWork")
    @ResponseBody
    public Integer res_deleteWork(Integer wor_id){
        Integer count=customerDao.res_deleteWork(wor_id);
        return count<1?0:1;
    }
//    修改工作经历--显示数据
    @RequestMapping("res_queryByIdWork")
    @ResponseBody
    public List<Map<String,Object>> res_queryByIdWork(Integer wor_id){
        return customerDao.res_queryByIdWork(wor_id);
    }
//    修改工作经历
    @RequestMapping("res_updateWork")
    @ResponseBody
    public Integer res_updateWork(Work_experience work_experience){
        Integer count=customerDao.res_updateWork(work_experience);
        return count<1?0:1;
    }
//    添加项目经历
    @RequestMapping("res_insertProject")
    @ResponseBody
    public Integer res_insertProject(Project_experience project_experience){
        Integer count=customerDao.res_insertProject(project_experience);
        return count<1?0:1;
    }
//    修改项目经历--查询数据
    @RequestMapping("res_queryByIdProject")
    @ResponseBody
    public List<Map<String,Object>> res_queryByIdProject(Integer pro_id){
        return customerDao.res_queryByIdProject(pro_id);
    }

    /*导航栏信息*/
    @RequestMapping("show_head")
    public String show_head(Model model){
        model.addAttribute("cusList",cusList);
        return "main/head";
    }

//    企业资料保存成功后，更新cusList
    @RequestMapping("ent_updateEid")
    @ResponseBody
    public String ent_updateEid(Integer cus_id,HttpSession session){
        cusList=entrepreneurDao.ent_cidFindeid(cus_id);
        session.setAttribute("sessionCusList",cusList);
        return "1";
    }

}
