package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaxing.account.pay.entity.ComPayRecord;
import com.huaxing.account.pay.entity.dto.ComPayRecordDto;
import com.huaxing.account.pay.service.ComPayRecordService;
import com.huaxing.account.pay.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.controller.ComPayRecordController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/18 1:13
 * Description: ComPayRecordController
 * ==================================
 */
@RestController
@RequestMapping("/compay")
public class ComPayRecordController {

    @Autowired
    private ComPayRecordService comPayRecordService;

    @GetMapping("/p_list")
    public JSONObject contract(Integer cId, String name, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (cId == null && name == null){
            return JsonUtils.page(0, 0, "", null);
        }
        PageInfo info = new PageInfo();
        List<ComPayRecordDto> comPayRecordDtos = comPayRecordService.selAllByCIdOrName(cId, name, page, limit, info);
        return JsonUtils.page(0, info.getTotal(), "", comPayRecordDtos);
    }

    @PostMapping("/insert")
    public JSONObject insert(ComPayRecordDto comPayRecordDto){
        return comPayRecordService.insert(comPayRecordDto);
    }

}
