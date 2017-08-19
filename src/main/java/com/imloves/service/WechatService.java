package com.imloves.service;

import me.chanjar.weixin.mp.bean.result.WxMpUser;

/**
 * Created by wujianchuan
 * 2017/8/19 12:35
 */
public interface WechatService {

    void wechatCustomerPersist(WxMpUser wxMpUser);
}
