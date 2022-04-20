package com.lzf.shirojwt.model;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author zongfang
 * @date 2022/4/20
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
