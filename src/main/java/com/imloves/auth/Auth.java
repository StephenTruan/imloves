package com.imloves.auth;

import com.imloves.model.SysUser;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by wujianchuan
 * 2017/8/29 13:50
 */

@Data
@AllArgsConstructor
public class Auth {

    private String token;

    private SysUser sysUser;
}
