package com.huaxing.account.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.ExcelController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 19:44
 * Description: ExcelController
 * ==================================
 */
@Controller
@RequestMapping("excel")
public class ExcelController {

    @GetMapping("contract")
    public String contract(){
        return "excel/contract";
    }

}
