package com.huaxing.account.pay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.IndexController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/15 11:53
 * Description: IndexController
 * ==================================
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/", "/index"})
    public String index(){
        return "index";
    }

}
