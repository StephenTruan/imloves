package com.imloves.security;

import com.imloves.model.SysUser;
import com.imloves.repository.SysUserRepository;
import com.imloves.util.RegexUtil;
import com.imloves.util.RoleUtil;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wujianchuan
 * 2017/8/28 17:00
 */

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    private final SysUserRepository sysUserRepository;

    private final RoleUtil roleUtil;

    JwtUserDetailServiceImpl(SysUserRepository sysUserRepository, RoleUtil roleUtil) {
        this.sysUserRepository = sysUserRepository;
        this.roleUtil = roleUtil;
    }

    @Override
    public JwtUser loadUserByUsername(String input) throws UsernameNotFoundException {

        SysUser sysUser = sysUserRepository.findByPhone(input);
        if (sysUser == null)
            throw new UsernameNotFoundException("用户不存在");
        List<String> roleNames = roleUtil.getRoleNamesByUser(sysUser);
        sysUser.setRoles(roleNames);
        return JwtUserFactory.create(sysUser);
    }
}
