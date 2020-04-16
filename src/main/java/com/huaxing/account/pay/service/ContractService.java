package com.huaxing.account.pay.service;

import com.huaxing.account.pay.entity.Contract;
import com.huaxing.account.pay.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.service.ContractService
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 18:07
 * Description: ContractService
 * ==================================
 */
@Service
public class ContractService {

    @Autowired
    private ContractMapper contractMapper;

    public List<Contract> selAllByCqName(Integer cId){
        Example example = new Example(Contract.class);
        example.createCriteria().andEqualTo("c_id", cId);
        List<Contract> list = contractMapper.selectByExample(example);
        return list;
    }

}
