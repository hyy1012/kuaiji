package com.huaxing.account.pay.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huaxing.account.pay.entity.dto.ContractDto;
import com.huaxing.account.pay.service.ContractService;
import com.huaxing.account.pay.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.controller.ContractController
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/15 16:05
 * Description: ContractController
 * ==================================
 */
@RestController
@RequestMapping("contract")
public class ContractController {

    @Autowired
    private ContractService contractService;

    @GetMapping("/list")
    public JSONObject contract(Integer cId, String name, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer limit) {
        if (cId == null && name == null){
            return JsonUtils.page(0, 0, "", null);
        }
        PageHelper.startPage(page, limit);
        List<ContractDto> list = contractService.selAllByCIdOrName(cId, name);
        PageInfo info = new PageInfo(list);
        return JsonUtils.page(0, info.getTotal(), "", list);
    }

    @PostMapping("/insert")
    public JSONObject insert(ContractDto contractDto){
        return contractService.insert(contractDto);
    }

    @PostMapping("/del")
    public JSONObject delete(Integer id){
        Integer i = contractService.delete(id);
        if (i == 0)
            return JsonUtils.common(500, "删除失败");
        else
            return JsonUtils.common(200, "删除成功");
    }

    @PostMapping("/upd")
    public JSONObject update(ContractDto contractDto){
        Integer i = contractService.update(contractDto);
        if (i == 0)
            return JsonUtils.common(500, "修改失败");
        else
            return JsonUtils.common(200, "修改成功");
    }

}
