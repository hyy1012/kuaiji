package com.huaxing.account.pay.service;

import com.huaxing.account.pay.entity.Company;
import com.huaxing.account.pay.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.service.CompanyService
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/16 23:50
 * Description: CompanyService
 * ==================================
 */
@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public List<Company> selAll(){
        return companyMapper.selectAll();
    }

    public List<Company> selById(Integer id){
        Example example = new Example(Company.class);
        example.createCriteria().andLike("id", "%" + id + "%");
        return companyMapper.selectByExample(example);
    }

    public List<String> selNamesByName(String name){
        name = "%" + name + "%";
        return companyMapper.selectNamesByName(name);
    }

}
