package com.linhu.sell.controller;

import com.linhu.sell.enums.ResultEnum;
import com.linhu.sell.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URLEncoder;

/**
 * @Author: linhu
 * @Date: 2019/1/7 19:50
 * @Version 1.0
 */
@Controller
@Slf4j
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private WxMpService wxMpService;
    @GetMapping("/authorize")
    public String authorize(@RequestParam("returnUrl") String returnurl){
        //第一步配置
        //第二步调用方法
        String url = "http://linhu.nat300.top/sell/wechat/userInfo";
        String result = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_BASE, URLEncoder.encode(returnurl));
        log.info("【微信网页授权】 获取code,result = {}",result);
        return "redirect:"+result;

    }
    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                           @RequestParam("state") String returnUrl){
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = new WxMpOAuth2AccessToken();
        try {
            wxMpOAuth2AccessToken = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.info("【微信网页授权】 {}",e);
            throw new SellException(ResultEnum.WECHAT_MP_ERROR.getCode(),e.getError().getErrorMsg());
        }
        String openId = wxMpOAuth2AccessToken.getOpenId();
        System.out.println("openID = "+openId);
        return "redirect:"+returnUrl+"?openid="+openId;
    }
}
