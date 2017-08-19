package com.imloves.service;

import com.imloves.model.Customer;
import com.imloves.repository.CustomerRepository;
import com.imloves.util.EncryptionUtil;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wujianchuan
 * 2017/8/19 12:36
 */
@Service
public class WechatServiceImpl implements WechatService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void wechatCustomerPersist(WxMpUser wxMpUser) {

        String openId = wxMpUser.getOpenId();
        Customer customer = customerRepository.findByOpenId(openId);
        if (customer == null) {
            customer = new Customer();
            customer.setNickName(wxMpUser.getNickname());
            customer.setOpenId(wxMpUser.getOpenId());
            customer.setPassword(EncryptionUtil.enctyption("000000", EncryptionUtil.MD5));
            if ("男".equals(wxMpUser.getSex())) {
                customer.setSex(1);
            } else if ("女".equals(wxMpUser.getSex())) {
                customer.setSex(2);
            }
            customer.setState(1);
            customer.setCity(wxMpUser.getCity());
            customerRepository.save(customer);
        }
    }
}
