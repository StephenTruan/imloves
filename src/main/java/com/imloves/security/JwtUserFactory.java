package com.imloves.security;

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
                mapToGrantedAuthorities(sysUser.getRoles()),
                sysUser.getUpdateTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
