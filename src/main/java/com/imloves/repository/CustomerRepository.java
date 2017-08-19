package com.imloves.repository;

import com.imloves.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wujianchuan
 * 2017/8/19 10:56
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByOpenId(String openId);
}
