package com.imloves.service;

import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
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
    SysUserRepository sysUserRepository;

    @Override
    public void wechatCustomerPersist(WxMpUser wxMpUser) {

        String openId = wxMpUser.getOpenId();
        SysUser sysUser = sysUserRepository.findByOpenId(openId);
        if (sysUser == null) {
            sysUser = new SysUser();
            sysUser.setUsername(wxMpUser.getNickname());
            sysUser.setOpenId(wxMpUser.getOpenId());
            sysUser.setPassword(EncryptionUtil.enctyption("000000", EncryptionUtil.MD5));
            if ("男".equals(wxMpUser.getSex())) {
                sysUser.setSex(1);
            } else if ("女".equals(wxMpUser.getSex())) {
                sysUser.setSex(2);
            }
            sysUser.setState(1);
            sysUser.setCity(wxMpUser.getCity());
            sysUserRepository.save(sysUser);
        }
    }
}
