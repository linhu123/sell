package com.linhu.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: linhu
 * @Date: 2019/1/7 20:26
 * @Version 1.0
 */

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    private String mpAppId;

    private String mpAppSecret;
}
