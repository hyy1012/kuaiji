package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.service.CompanyService;
import com.huaxing.account.pay.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.controller.CompanyController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 23:35
 * Description: CompanyController
 * ==================================
 */
@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/list")
    public JSONObject company(Integer id, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        List<Company> companies = null;
        if (id != null){
            PageHelper.startPage(page, limit);
            companies = companyService.selById(id);
            PageInfo info = new PageInfo(companies);
            return JsonUtils.page(0, info.getTotal(), "", companies);
        }
        PageHelper.startPage(page, limit);
        companies = companyService.selAll();
        PageInfo info = new PageInfo(companies);
        return JsonUtils.page(0, info.getTotal(), companies);
    }

    @GetMapping("/tensl")
    public List<String> tensl(String name){
        PageHelper.startPage(0,10);
        return companyService.selNamesByName(name);
    }

}
