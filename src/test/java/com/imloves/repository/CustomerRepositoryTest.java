package com.imloves.repository;

import com.imloves.model.Customer;
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
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void persistTest() {

        Customer customer = new Customer("测试账号", "123456", "xdfk#r6lsicla", 1, "北京", 1);
        customerRepository.save(customer);
        System.out.println(customerRepository.findOne(customer.getUuid()));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customer.setPassword("000000");
        customerRepository.save(customer);
        System.out.println(customerRepository.findOne(customer.getUuid()));
        customerRepository.delete(customer);
    }

    @Test
    public void queryByOpenIdTest() {

        Customer customer = customerRepository.findByOpenId("xdfk#r6lsicla");
        System.out.println(customer);
    }
}