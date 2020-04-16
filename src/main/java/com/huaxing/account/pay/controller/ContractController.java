package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.ContractController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/15 16:05
 * Description: ContractController
 * ==================================
 */
@Controller
@RequestMapping("contract")
public class ContractController {

    @GetMapping("/{c_id}")
    public String contract(@PathVariable("c_id") Integer cId) {
        return "excel/contract";
    }

}
