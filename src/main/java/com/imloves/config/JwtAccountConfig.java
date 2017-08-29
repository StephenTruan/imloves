package com.imloves.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wujianchuan
 * 2017/8/29 11:27
 */

@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtAccountConfig {

    private String header;

    private String secret;

    private Long expiration;

    private String tokenHead;
}
