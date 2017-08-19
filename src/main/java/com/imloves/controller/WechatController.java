package com.imloves.controller;

import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * Created by wujianchuan
 * 2017/8/15 19:45
 */

@Controller
@RequestMapping("/wechat")
@Slf4j
public class WechatController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/authorize")
    public String authorize() {

        String returnUrl = "http://www.yangmb.top";
        String url = "http://imloves.natapp1.cc/wechat/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAUTH2_SCOPE_USER_INFO, URLEncoder.encode(returnUrl));

        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userIfo(@RequestParam("code") String code,
                          @RequestParam("state") String returnUrl) {

        WxMpOAuth2AccessToken wxMpOAuth2AccessToken;
        WxMpUser wxMpUser = null;
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
            wxMpUser = wxMpService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            log.error("【微信网页授权】{}", e);
            e.printStackTrace();
        }

        return "redirect:" + returnUrl;
    }
}
