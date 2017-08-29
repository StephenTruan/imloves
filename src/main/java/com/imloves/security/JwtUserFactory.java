package com.imloves.security;

import com.imloves.model.SysRole;
import com.imloves.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wujianchuan
 * 2017/8/19 22:02
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(SysUser sysUser) {
        return new JwtUser(
                sysUser.getId(),
                sysUser.getUsername(),
                sysUser.getPassword(),
                map2GrantedAuthorities(sysUser.getRoles()),
                sysUser.getUpdateTime()
        );
    }

    private static List<GrantedAuthority> map2GrantedAuthorities(List<SysRole> sysRoles) {
        return sysRoles.stream()
                .map(sysRole -> role2SimpleGrantedAuthority(sysRole))
                .collect(Collectors.toList());
    }

    private static SimpleGrantedAuthority role2SimpleGrantedAuthority(SysRole sysRole) {
        return new SimpleGrantedAuthority(sysRole.getName());
    }
}
