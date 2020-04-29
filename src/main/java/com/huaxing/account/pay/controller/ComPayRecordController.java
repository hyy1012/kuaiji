package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.huaxing.account.pay.entity.dto.ComPayRecordDto;
import com.huaxing.account.pay.entity.dto.ContractDto;
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

    @PostMapping("/del")
    public JSONObject delete(Integer id){
        Integer i = comPayRecordService.delete(id);
        if (i == 0)
            return JsonUtils.common(500, "删除失败");
        else
            return JsonUtils.common(200, "删除成功");
    }

    @PostMapping("/upd")
    public JSONObject update(ComPayRecordDto comPayRecordDto){
        Integer i = comPayRecordService.update(comPayRecordDto);
        if (i == 0)
            return JsonUtils.common(500, "修改失败");
        else
            return JsonUtils.common(200, "修改成功");
    }

}
