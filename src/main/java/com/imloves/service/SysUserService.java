package com.imloves.service;

import com.imloves.model.SysUser;

/**
 * Created by wujianchuan
 * 2017/9/9 18:15
 */
public interface SysUserService {

    SysUser save(SysUser sysUser);

    SysUser findByPhone(String phone);
}
