package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.huaxing.account.pay.entity.AcceptanceBill;
import com.huaxing.account.pay.service.AcceptanceBillService;
import com.huaxing.account.pay.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.controller.AcceptanceBill
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/22 16:27
 * Description: AcceptanceBill
 * ==================================
 */
@RestController
@RequestMapping("abill")
public class AcceptanceBillController {

    @Autowired
    private AcceptanceBillService acceptanceBillService;

    @GetMapping("/list")
    public JSONObject contract(String year) {
        if (year == null){
            return JsonUtils.page(0,null);
        }
        List<AcceptanceBill> list = acceptanceBillService.selAllByYear(year);
        return JsonUtils.page(0, list);
    }

    @PostMapping("/save")
    public JSONObject save(AcceptanceBill acceptanceBill){
        Integer i = null;
        try {
            i = acceptanceBillService.save(acceptanceBill);
        } catch (Exception e) {
            return JsonUtils.common(500, "提交失败，" + e.getMessage());
        }
        if (i == 0)
            return JsonUtils.common(500, "提交失败");
        else
            return JsonUtils.common(200, "提交成功");
    }

}
