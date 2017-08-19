package com.imloves.repository;

import com.imloves.model.WxCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wujianchuan
 * 2017/8/19 10:56
 */
public interface WxCustomerRepository extends JpaRepository<WxCustomer, Long> {
}
