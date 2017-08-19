package com.imloves.repository;

import com.imloves.model.WxCustomer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wujianchuan
 * 2017/8/19 11:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WxCustomerRepositoryTest {

    @Autowired
    private WxCustomerRepository wxCustomerRepository;

    @Test
    public void persistTest() {

        WxCustomer wxCustomer = new WxCustomer("测试账号", "123456", "xdfk#r6lsicla", 1, "北京", 1);
        wxCustomerRepository.save(wxCustomer);
        System.out.println(wxCustomerRepository.findOne(wxCustomer.getUuid()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        wxCustomer.setPassword("000000");
        wxCustomerRepository.save(wxCustomer);
        System.out.println(wxCustomerRepository.findOne(wxCustomer.getUuid()));
        wxCustomerRepository.delete(wxCustomer);
    }
}