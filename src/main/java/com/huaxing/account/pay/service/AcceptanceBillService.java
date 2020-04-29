package com.huaxing.account.pay.service;

import cn.hutool.core.date.DateUtil;
import com.huaxing.account.pay.entity.AcceptanceBill;
import com.huaxing.account.pay.mapper.AcceptanceBillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Class Name: com.huaxing.account.pay.service.AcceptanceBillService
 * ==================================
 * Author Dell Lisufer
 * Date 2020/4/24 15:56
 * Description: AcceptanceBillService
 * ==================================
 */
@Service
public class AcceptanceBillService {

    @Autowired
    private AcceptanceBillMapper acceptanceBillMapper;

    public List<AcceptanceBill> selAllByYear(String year){
        Example example = new Example(AcceptanceBill.class);
        example.createCriteria().andCondition("year(rz_time) = ", year);
        List<AcceptanceBill> list = acceptanceBillMapper.selectByExample(example);
        return list;
    }

    public Integer save(AcceptanceBill acceptanceBill){
        if (acceptanceBill.getId() == null){
            if (acceptanceBill.getNo() == null){
                Integer no = acceptanceBillMapper.selMaxNo(DateUtil.year(acceptanceBill.getRzTime()));
                if (no == null)
                    no = 0;
                acceptanceBill.setNo(++no);
            }
            return acceptanceBillMapper.insert(acceptanceBill);
        }else {
            acceptanceBill.setRzTime(null);
            return acceptanceBillMapper.updateByPrimaryKeySelective(acceptanceBill);
        }
    }

}
