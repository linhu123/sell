package com.linhu.sell.controller;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: linhu
 * @Date: 2019/1/7 16:20
 * @Version 1.0
 */
@Controller
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code) {
        JsonParser parser = new JsonParser();
        String openid = null;
        log.info("进入auth 方法：：：：：：：");
        log.info("code = {}", code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxcc8ca49e9754f20e&secret=3a1a7a4231cb189e58af270ac514ac56&code=" + code + "&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String reString = restTemplate.getForObject(url, String.class);
        log.info("response = {}", reString);
        JsonObject response = (JsonObject) parser.parse(reString);
        if(response.get("errCode") == null){
            openid = response.get("openid").toString();
            System.out.println(openid);
        }else{
            String errCode = response.get("errCode").toString();
            String errmsg = response.get("errmsg").toString();
            log.error("get openid error. errCode["+errCode+"], errmsg["+errmsg+"]");
        }
    }

//    public void test1() {
//        try {
//            CloseableHttpClient client = null;
//            CloseableHttpResponse response = null;
//            try {
//                HttpGet httpGet = new HttpGet(uri + "/test1?code=001&name=测试");
//
//                client = HttpClients.createDefault();
//                response = client.execute(httpGet);
//                HttpEntity entity = response.getEntity();
//                String result = EntityUtils.toString(entity);
//                System.out.println(result);
//            } finally {
//                if (response != null) {
//                    response.close();
//                }
//                if (client != null) {
//                    client.close();
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
