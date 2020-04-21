package com.huaxing.account.pay.controller.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.jump.UpkeepController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 23:36
 * Description: UpkeepController
 * ==================================
 */
@Controller
@RequestMapping("upkeep")
public class UpkeepController {

    @GetMapping("company")
    public String contract(){
        return "upkeep/company";
    }

}
