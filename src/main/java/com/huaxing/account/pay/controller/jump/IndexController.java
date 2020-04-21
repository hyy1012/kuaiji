package com.huaxing.account.pay.controller.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.jump.IndexController
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

    @RequestMapping("/home/console")
    public String console(){
        return "home/console";
    }
}
