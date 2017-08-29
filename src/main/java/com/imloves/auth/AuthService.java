package com.imloves.auth;

import com.imloves.model.SysUser;

/**
 * Created by wujianchuan
 * 2017/8/29 13:51
 */
public interface AuthService {

    SysUser register(SysUser user);

    String login(String username, String password);

    String refresh(String oldToken);
}
