package com.imloves.security;

import java.io.Serializable;

/**
 * Created by wujianchuan
 * 2017/8/31 20:27
 */
public class JwtAuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 4903196434187832426L;

    private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}
