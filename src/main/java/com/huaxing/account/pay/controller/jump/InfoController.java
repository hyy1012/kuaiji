package com.huaxing.account.pay.controller.jump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class Name: com.huaxing.account.pay.controller.jump.InputController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/18 11:01
 * Description: DInputController
 * ==================================
 */
@Controller
@RequestMapping("/info")
public class InfoController {

    @GetMapping("/d_input")
    public String dInput(){
        return "info/d_input";
    }

}
